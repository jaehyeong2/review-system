package jjfactory.common.review.infra.question;

import jjfactory.common.global.exception.ResourceNotFoundException;
import jjfactory.common.review.domain.question.Category;
import jjfactory.common.review.domain.question.Question;
import jjfactory.common.review.domain.question.QuestionnaireReader;
import jjfactory.common.review.domain.question.Questionnaire;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class QuestionnaireReaderImpl implements QuestionnaireReader {
    private final QuestionnaireRepository questionnaireRepository;
    private final CategoryRepository categoryRepository;
    private final QuestionRepository questionRepository;

    @Override
    public Questionnaire getQuestionnaire(Long id) {
        return questionnaireRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("questionnaire not found");
        });
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("category not found");
        });
    }

    @Override
    public Question getQuestion(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("question not found");
        });
    }
}
