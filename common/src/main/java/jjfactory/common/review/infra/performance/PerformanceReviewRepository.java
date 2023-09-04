package jjfactory.common.review.infra.performance;

import jjfactory.common.review.domain.performance.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {
}