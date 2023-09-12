package jjfactory.common.review.domain.question;


import java.util.List;

public interface QuestionnaireService {
    Long createQuestionnaire(QuestionnaireCommand.Create command);
    void delete(Long id);
    void update(Long id, QuestionnaireCommand.Update command);
    void openQuestionnaire(Long id);
    void clone(Long id, Long targetMetaId);
    List<QuestionnaireInfo.ListResponse> getQuestionnaires(Long metaId);
    QuestionnaireInfo.DetailResponse getQuestionnaire(Long id);
}
