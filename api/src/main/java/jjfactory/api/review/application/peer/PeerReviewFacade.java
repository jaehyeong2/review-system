package jjfactory.api.review.application.peer;

import jjfactory.common.review.domain.peer.PeerReviewerInfo;
import jjfactory.common.review.domain.peer.PeerReviewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PeerReviewFacade {
    private final PeerReviewerService peerReviewerService;

    public void addTeamMembersToPeerReviewer(Long receiveUserId, Long metaId) {
        peerReviewerService.addTeamMembersToPeerReviewer(receiveUserId, metaId);
    }

    public List<PeerReviewerInfo.ListResponse> findListByReceiveUserIdAndMetaId(Long receiveUserId, Long metaId) {
        return peerReviewerService.findListByReceiveUserIdAndMetaId(receiveUserId, metaId);
    }

    public void delete(Long id) {
        peerReviewerService.delete(id);
    }
}
