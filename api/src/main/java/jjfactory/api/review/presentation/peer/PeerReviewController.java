package jjfactory.api.review.presentation.peer;

import jjfactory.api.review.presentation.peer.dto.PeerReviewDtoMapper;
import jjfactory.api.review.application.peer.PeerReviewFacade;
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
    private final PeerReviewDtoMapper peerReviewDtoMapper;

    @PostMapping("/reviewr")
    public CommonResponse addTeamMembersToPeerReviewer(@RequestParam Long metaId) {
        //todo
        Long loginUserId = 23L;

        peerReviewFacade.addTeamMembersToPeerReviewer(loginUserId, metaId);
        return CommonResponse.ok();
    }

    @GetMapping("/reviewr")
    public CommonResponse<List<PeerReviewerInfo.ListResponse>> findListByReceiveUserIdAndMetaId(@RequestParam Long metaId) {
        //todo
        Long loginUserId = 23L;

        return new CommonResponse(peerReviewFacade.findListByReceiveUserIdAndMetaId(loginUserId, metaId)
                .stream().map(peerReviewDtoMapper::of)
                .toList());
    }

    @DeleteMapping("/reviewr/{id}")
    public CommonResponse delete(@PathVariable Long id) {
        peerReviewFacade.delete(id);
        return CommonResponse.ok();
    }
}
