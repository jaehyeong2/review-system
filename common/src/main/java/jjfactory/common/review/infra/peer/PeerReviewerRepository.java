package jjfactory.common.review.infra.peer;

import jjfactory.common.review.domain.peer.PeerReviewer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeerReviewerRepository extends JpaRepository<PeerReviewer, Long> {
    List<PeerReviewer> findAllByUserIdAndMetaId(Long userId, Long metaId);
}