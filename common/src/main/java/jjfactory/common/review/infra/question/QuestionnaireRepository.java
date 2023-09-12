package jjfactory.common.review.infra.question;

import jjfactory.common.review.domain.question.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
}