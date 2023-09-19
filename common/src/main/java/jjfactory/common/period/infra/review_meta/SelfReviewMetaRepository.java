package jjfactory.common.period.infra.review_meta;

import jjfactory.common.period.domain.review_meta.SelfReviewMeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelfReviewMetaRepository extends JpaRepository<SelfReviewMeta, Long> {
}