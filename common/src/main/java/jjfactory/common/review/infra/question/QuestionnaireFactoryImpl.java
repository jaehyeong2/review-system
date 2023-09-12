package jjfactory.common.review.infra.question;

import jjfactory.common.review.domain.question.Category;
import jjfactory.common.review.domain.question.Question;
import jjfactory.common.review.domain.question.Questionnaire;
import jjfactory.common.review.domain.question.QuestionnaireFactory;
import jjfactory.common.review.infra.question.CategoryRepository;
import jjfactory.common.review.infra.question.QuestionRepository;
import jjfactory.common.review.infra.question.QuestionnaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class QuestionnaireFactoryImpl implements QuestionnaireFactory {
    private final QuestionnaireRepository questionnaireRepository;
    private final CategoryRepository categoryRepository;
    private final QuestionRepository questionRepository;
    @Override
    public Question writeQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Questionnaire writeQuestionnaire(Questionnaire questionnaire) {
        return questionnaireRepository.save(questionnaire);
    }

    @Override
    public Category writeCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        questionnaireRepository.deleteById(id);
    }
}
