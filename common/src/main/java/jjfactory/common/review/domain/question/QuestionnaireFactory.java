package jjfactory.common.review.domain.question;

public interface QuestionnaireFactory {
    Questionnaire writeQuestionnaire(QuestionnaireCommand.Create command);

    void cloneQuestionnaire(Questionnaire questionnaire);

    void delete(Long id);
    Long update(Long questionnaireId, QuestionnaireCommand.Update command);
}
