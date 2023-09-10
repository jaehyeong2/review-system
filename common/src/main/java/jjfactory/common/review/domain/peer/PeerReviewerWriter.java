package jjfactory.common.review.domain.peer;

public interface PeerReviewerWriter {
    PeerReviewer write(PeerReviewer peerReviewer);
    void deleteById(Long id);
}
