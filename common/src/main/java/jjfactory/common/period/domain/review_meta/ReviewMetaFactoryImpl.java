package jjfactory.common.period.domain.review_meta;

import jjfactory.common.period.infra.review_meta.LeaderReviewMetaRepository;
import jjfactory.common.period.infra.review_meta.PeerReviewMetaRepository;
import jjfactory.common.period.infra.review_meta.PerformanceReviewMetaRepository;
import jjfactory.common.period.infra.review_meta.TotalReviewMetaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReviewMetaFactoryImpl implements ReviewMetaFactory {
    private final TotalReviewMetaRepository totalReviewMetaRepository;
    private final PeerReviewMetaRepository peerReviewMetaRepository;
    private final PerformanceReviewMetaRepository performanceReviewMetaRepository;
    private final LeaderReviewMetaRepository leaderReviewMetaRepository;

    @Override
    public Long writeTotalReviewMeta(ReviewMetaCommand.Create command) {
        TotalReviewMeta initTotalReviewMeta = command.toEntity();

        TotalReviewMeta totalReviewMeta = totalReviewMetaRepository.save(initTotalReviewMeta);

        if (command.isReviewLeaderIncluded()) {

        }

        if (command.isReviewSelfIncluded()) {

        }

        if (command.isReviewPeerIncluded()) {

        }

        return totalReviewMeta.getId();
    }
}
