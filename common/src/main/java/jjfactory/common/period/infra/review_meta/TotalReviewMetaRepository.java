package jjfactory.common.period.infra.review_meta;

import jjfactory.common.period.domain.review_meta.TotalReviewMeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TotalReviewMetaRepository extends JpaRepository<TotalReviewMeta, Long> {
}