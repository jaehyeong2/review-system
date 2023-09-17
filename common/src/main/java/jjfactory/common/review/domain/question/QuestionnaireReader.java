package jjfactory.common.review.domain.question;

import java.util.List;

public interface QuestionnaireReader {
    Questionnaire getQuestionnaire(Long id);
    List<Questionnaire> getQuestionnairesByMetaId(Long metaId);
    Category getCategoryOrThrow(Long id);
    Category getCategoryOrNull(Long id);
    Question getQuestionOrThrow(Long id);
    Question getQuestionOrNull(Long id);
}
