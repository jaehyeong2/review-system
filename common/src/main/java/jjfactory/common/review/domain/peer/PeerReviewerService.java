package jjfactory.common.review.domain.peer;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface PeerReviewerService {
    void addTeamMembersToPeerReviewer(Long receiveUserId, Long metaId);
    List<PeerReviewerInfo.ListResponse> findListByReceiveUserIdAndMetaId(Long receiveUserId, Long metaId);
    void delete(Long peerReviewerId);
    void confirmPeerReviewer(Long userId, Set<Long> peerReviewerIds, Long metaId);
}
