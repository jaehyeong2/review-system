package jjfactory.common.review.domain.peer;

import jjfactory.common.period.domain.review_meta.PeerReviewMeta;
import jjfactory.common.period.domain.review_meta.ReviewMetaReader;
import jjfactory.common.review.domain.answer.ReviewAnswerSheet;
import jjfactory.common.review.domain.answer.ReviewAnswerWriter;
import jjfactory.common.user.domain.team.UserTeamHistory;
import jjfactory.common.user.domain.team.UserTeamHistoryReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PeerReviewerServiceImpl implements PeerReviewerService {
    private final PeerReviewerReader peerReviewerReader;
    private final PeerReviewerWriter peerReviewerWriter;
    private final PeerReviewerMapper peerReviewerMapper;
    private final UserTeamHistoryReader userTeamHistoryReader;
    private final ReviewMetaReader reviewMetaReader;
    private final ReviewAnswerWriter reviewAnswerWriter;

    @Transactional
    @Override
    public void addTeamMembersToPeerReviewer(Long receiveUserId, Long metaId) {
        PeerReviewMeta peerReviewMeta = reviewMetaReader.getPeerReviewMeta(metaId);
        long yearQuarterId = peerReviewMeta.getTotalReviewMeta().getYearQuarterId();

        UserTeamHistory userTeamHistory = userTeamHistoryReader
                .findOneByUserIdAndYearQuarterId(receiveUserId, yearQuarterId);

        List<Long> teamMemberIds = userTeamHistoryReader.findAllByTeamIdExceptUser(userTeamHistory.getTeamId(), receiveUserId)
                .stream().map(uth -> uth.getUser().getId())
                .toList();

        Set<Long> peerReviewerIdSet = peerReviewerReader.getByUserIdAndMetaId(receiveUserId, metaId)
                .stream().map(PeerReviewer::getId).collect(Collectors.toSet());

        teamMemberIds.forEach(memberId -> {
            if (!peerReviewerIdSet.contains(memberId)) {
                PeerReviewer peerReviewer = PeerReviewer.createTeamMember(memberId, receiveUserId, metaId);
                peerReviewerWriter.write(peerReviewer);
            }
        });

    }

    @Transactional(readOnly = true)
    @Override
    public List<PeerReviewerInfo.ListResponse> findListByReceiveUserIdAndMetaId(Long receiveUserId, Long metaId) {
        return peerReviewerReader.getByUserIdAndMetaId(receiveUserId, metaId)
                .stream().map(peerReviewerMapper::of)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void delete(Long peerReviewerId) {
        PeerReviewer peerReviewer = peerReviewerReader.getOrThrow(peerReviewerId);
        peerReviewerWriter.deleteById(peerReviewer.getId());
    }

    @Transactional
    @Override
    public void confirmPeerReviewer(Long userId, Set<Long> peerReviewerIds, Long metaId){
        peerReviewerIds.forEach(id -> {
            PeerReviewer peerReviewer = peerReviewerReader.getOrThrow(id);
            peerReviewer.submit();

            ReviewAnswerSheet reviewAnswerSheet = ReviewAnswerSheet.ofPeer(userId, peerReviewer.getEvaluatorId(), metaId);
            reviewAnswerWriter.writeAnswerSheet(reviewAnswerSheet);
        });
    }
}
