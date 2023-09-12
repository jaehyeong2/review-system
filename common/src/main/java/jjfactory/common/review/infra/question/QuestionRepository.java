package jjfactory.common.review.infra.question;

import jjfactory.common.review.domain.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}