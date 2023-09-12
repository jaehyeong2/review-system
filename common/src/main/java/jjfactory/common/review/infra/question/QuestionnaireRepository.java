package jjfactory.common.review.infra.question;

import jjfactory.common.review.domain.question.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
    List<Questionnaire> findAllByMetaId(Long metaId);
}