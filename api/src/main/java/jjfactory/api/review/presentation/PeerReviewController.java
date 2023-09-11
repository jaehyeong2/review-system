package jjfactory.api.review.presentation;

import jjfactory.api.review.qpplication.peer.PeerReviewFacade;
import jjfactory.common.global.response.CommonResponse;
import jjfactory.common.review.domain.peer.PeerReviewerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/reviews/peer")
@RestController
public class PeerReviewController {
    private final PeerReviewFacade peerReviewFacade;

    @PostMapping("/reviewr")
    public CommonResponse addTeamMembersToPeerReviewer(@RequestParam Long metaId) {
        //todo
        Long loginUserId = 23L;

        peerReviewFacade.addTeamMembersToPeerReviewer(loginUserId, metaId);
        return CommonResponse.ok();
    }

    @GetMapping("/reviewr")
    public List<PeerReviewerInfo.ListResponse> findListByReceiveUserIdAndMetaId(@RequestParam Long metaId) {
        //todo
        Long loginUserId = 23L;

        return peerReviewFacade.findListByReceiveUserIdAndMetaId(loginUserId, metaId);
    }

    @DeleteMapping("/reviewr/{id}")
    public CommonResponse delete(@PathVariable Long id) {
        peerReviewFacade.delete(id);
        return CommonResponse.ok();
    }
}
