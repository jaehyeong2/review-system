package jjfactory.common.period.infra.review_meta;

import jjfactory.common.period.domain.review_meta.PerformanceReviewMeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceReviewMetaRepository extends JpaRepository<PerformanceReviewMeta, Long> {
}