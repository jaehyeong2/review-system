package jjfactory.common.review.domain.peer;

import java.util.List;

public interface PeerReviewerReader {
    PeerReviewer getOrThrow(Long id);
    List<PeerReviewer> getByUserIdAndMetaId(Long userId, Long metaId);
}
