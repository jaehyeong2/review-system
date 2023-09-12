package jjfactory.common.review.domain.question;

public interface QuestionnaireReader {
    Questionnaire getQuestionnaire(Long id);
    Category getCategory(Long id);
    Question getQuestion(Long id);
}
