package jjfactory.common.review.infra;

import jjfactory.common.review.domain.ReviewAnswerSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewAnswerSheetRepository extends JpaRepository<ReviewAnswerSheet, Long> {
}