package jjfactory.common.review.domain.question;

import java.util.List;

public interface QuestionnaireReader {
    Questionnaire getQuestionnaire(Long id);
    List<Questionnaire> getQuestionnairesByMetaId(Long metaId);
    Category getCategory(Long id);
    Question getQuestion(Long id);
}
