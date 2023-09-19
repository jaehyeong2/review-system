package jjfactory.common.period.infra.review_meta;

import jjfactory.common.period.domain.review_meta.LeadershipReviewMeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaderReviewMetaRepository extends JpaRepository<LeadershipReviewMeta, Long> {
}