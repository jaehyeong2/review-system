package jjfactory.common.period.domain.review_meta;

import jjfactory.common.period.infra.review_meta.LeaderReviewMetaRepository;
import jjfactory.common.period.infra.review_meta.PeerReviewMetaRepository;
import jjfactory.common.period.infra.review_meta.SelfReviewMetaRepository;
import jjfactory.common.period.infra.review_meta.TotalReviewMetaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReviewMetaFactoryImpl implements ReviewMetaFactory {
    private final TotalReviewMetaRepository totalReviewMetaRepository;
    private final PeerReviewMetaRepository peerReviewMetaRepository;
    private final SelfReviewMetaRepository selfReviewMetaRepository;
    private final LeaderReviewMetaRepository leaderReviewMetaRepository;

    @Override
    public Long writeTotalReviewMeta(ReviewMetaCommand.Create command) {
        TotalReviewMeta initTotalReviewMeta = command.toEntity();

        TotalReviewMeta totalReviewMeta = totalReviewMetaRepository.save(initTotalReviewMeta);

        if (command.isLeadershipIncluded()) {
            writeLeadershipReviewMeta(command.getLeadershipReviewMeta().toEntity(totalReviewMeta));
        }

        if (command.isSelfIncluded()) {
            writeSelfReviewMeta(command.getSelfReviewMeta().toEntity(totalReviewMeta));
        }

        if (command.isPeerIncluded()) {
            writePeerReviewMeta(command.getPeerReviewMata().toEntity(totalReviewMeta));
        }

        return totalReviewMeta.getId();
    }

    private PeerReviewMeta writePeerReviewMeta(PeerReviewMeta peerReviewMeta){
        return peerReviewMetaRepository.save(peerReviewMeta);
    }

    private SelfReviewMeta writeSelfReviewMeta(SelfReviewMeta selfReviewMeta){
        return selfReviewMetaRepository.save(selfReviewMeta);
    }

    private LeadershipReviewMeta writeLeadershipReviewMeta(LeadershipReviewMeta leadershipReviewMeta){
        return leaderReviewMetaRepository.save(leadershipReviewMeta);
    }
}
