package jjfactory.common.review.domain.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Component
public class QuestionnaireServiceImpl implements QuestionnaireService {
    private final QuestionnaireFactory questionnaireFactory;
    private final QuestionnaireReader questionnaireReader;
    @Override
    public Long createQuestionnaire(QuestionnaireCommand.Create command) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Questionnaire questionnaire = questionnaireReader.getQuestionnaire(id);
        questionnaireFactory.delete(questionnaire.getId());
    }

    @Override
    public void update(Long id, QuestionnaireCommand.Update command) {

    }

    @Override
    public void openQuestionnaire(Long id) {
        Questionnaire questionnaire = questionnaireReader.getQuestionnaire(id);
        questionnaire.open();
    }

    @Override
    public void clone(Long id, Long targetMetaId) {

    }

    @Transactional(readOnly = true)
    @Override
    public List<QuestionnaireInfo.ListResponse> getQuestionnaires(Long metaId) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public QuestionnaireInfo.DetailResponse getQuestionnaire(Long id) {
        return null;
    }
}
