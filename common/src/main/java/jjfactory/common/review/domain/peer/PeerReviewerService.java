package jjfactory.common.review.domain.peer;

import java.util.List;

public interface PeerReviewerService {
    void addTeamMembersToPeerReviewer(Long receiveUserId, Long metaId);
    List<PeerReviewerInfo.ListResponse> findListByReceiveUserIdAndMetaId(Long receiveUserId, Long metaId);
    void delete(Long id);
}
