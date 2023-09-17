package jjfactory.common.review.infra.question;

import jjfactory.common.global.exception.ConflictException;
import jjfactory.common.review.domain.question.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class QuestionnaireFactoryImpl implements QuestionnaireFactory {
    private final QuestionnaireRepository questionnaireRepository;
    private final CategoryRepository categoryRepository;
    private final QuestionRepository questionRepository;
    private final QuestionnaireReader questionnaireReader;

    @Override
    public Questionnaire writeQuestionnaire(QuestionnaireCommand.Create command) {
        Questionnaire initQuestionnaire = command.toEntity();
        Questionnaire questionnaire = questionnaireRepository.save(initQuestionnaire);

        command.getCategories().forEach(categoryCommand -> {
            Category initCategory = categoryCommand.toEntity(questionnaire);
            Category category = writeCategory(initCategory);

            categoryCommand.getQuestions().forEach(questionCommand -> {
                Question initQuestion = questionCommand.toEntity(category);
                writeQuestion(initQuestion);
            });
        });

        return questionnaire;
    }
    private Category writeCategory(Category category) {
        return categoryRepository.save(category);
    }
    private Question writeQuestion(Question question) {
        return questionRepository.save(question);
    }


    @Override
    public void delete(Long id) {
        questionnaireRepository.deleteById(id);
    }

    @Override
    public Long update(Long questionnaireId, QuestionnaireCommand.Update command) {
        Questionnaire questionnaire = questionnaireReader.getQuestionnaire(questionnaireId);
        Set<QuestionnaireCommand.UpdateCategory> categoryCommands = command.getCategories();

        Set<QuestionnaireCommand.UpdateCategory> categorySeqDuplicateCheckSet = categoryCommands.stream()
                .filter(category -> Collections.frequency(categoryCommands, category.getSeq()) > 1)
                .collect(Collectors.toSet());

        if (!categorySeqDuplicateCheckSet.isEmpty()) throw new InvalidParameterException("카테고리 seq가 중복되었습니다.");

        questionnaire.updateQuestionnaire(command.getTitle(), command.getDescription());

        for (QuestionnaireCommand.UpdateCategory categoryCommand : categoryCommands) {
            Category category = questionnaireReader.getCategoryOrNull(categoryCommand.getId());

            if (category == null) {
                category = writeCategory(categoryCommand.toEntity(questionnaire));
            } else {
                category.update(categoryCommand.getTitle(), categoryCommand.getDescription(), categoryCommand.getSeq());
            }

            for (QuestionnaireCommand.UpdateQuestion questionCommand : categoryCommand.getQuestions()) {
                Question question = questionnaireReader.getQuestionOrNull(questionCommand.getId());

                if (question == null) {
                    writeQuestion(questionCommand.toEntity(category));
                } else {
                    question.update(questionCommand.getContent(), questionCommand.getType(), questionCommand.getSeq());
                }
            }
        }

        return questionnaireId;
    }
}
