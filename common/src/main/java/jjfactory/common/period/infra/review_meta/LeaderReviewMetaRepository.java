package jjfactory.common.period.infra.review_meta;

import jjfactory.common.period.domain.review_meta.LeaderReviewMeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaderReviewMetaRepository extends JpaRepository<LeaderReviewMeta, Long> {
}