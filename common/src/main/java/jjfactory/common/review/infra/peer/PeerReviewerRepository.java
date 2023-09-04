package jjfactory.common.review.infra.peer;

import jjfactory.common.review.domain.peer.PeerReviewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeerReviewerRepository extends JpaRepository<PeerReviewer, Long> {
}