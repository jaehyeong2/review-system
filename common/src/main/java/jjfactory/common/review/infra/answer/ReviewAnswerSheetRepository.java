package jjfactory.common.review.infra.answer;

import jjfactory.common.review.domain.answer.ReviewAnswerSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewAnswerSheetRepository extends JpaRepository<ReviewAnswerSheet, Long> {
}