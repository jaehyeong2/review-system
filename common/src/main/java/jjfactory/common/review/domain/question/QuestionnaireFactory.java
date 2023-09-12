package jjfactory.common.review.domain.question;

public interface QuestionnaireFactory {
    Question writeQuestion(Question question);
    Questionnaire writeQuestionnaire(Questionnaire questionnaire);
    Category writeCategory(Category category);

    void delete(Long id);
}
