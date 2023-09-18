package jjfactory.admin.review.question.application;

import jjfactory.common.review.domain.question.QuestionnaireCommand;
import jjfactory.common.review.domain.question.QuestionnaireInfo;
import jjfactory.common.review.domain.question.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionnaireFacade {
    private final QuestionnaireService questionnaireService;

    public Long createQuestionnaire(QuestionnaireCommand.Create command) {
        return questionnaireService.createQuestionnaire(command);
    }

    public void delete(Long id) {
        questionnaireService.delete(id);
    }

    public Long update(Long id, QuestionnaireCommand.Update command) {
        return questionnaireService.update(id, command);
    }

    public void openQuestionnaire(Long id) {
        questionnaireService.openQuestionnaire(id);
    }

    public void clone(Long id, Long targetMetaId) {
        questionnaireService.clone(id, targetMetaId);
    }

    public List<QuestionnaireInfo.ListResponse> getQuestionnaires(Long metaId) {
        return questionnaireService.getQuestionnaires(metaId);
    }

    public QuestionnaireInfo.DetailResponse getQuestionnaire(Long id) {
        return questionnaireService.getQuestionnaire(id);
    }
}
