package jjfactory.common.period.infra.review_meta;

import jjfactory.common.period.domain.review_meta.PeerReviewMeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeerReviewMetaRepository extends JpaRepository<PeerReviewMeta, Long> {
}