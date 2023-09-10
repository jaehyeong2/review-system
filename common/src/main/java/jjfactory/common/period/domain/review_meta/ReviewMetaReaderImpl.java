package jjfactory.common.period.domain.review_meta;


import jjfactory.common.global.exception.ResourceNotFoundException;
import jjfactory.common.period.infra.review_meta.LeaderReviewMetaRepository;
import jjfactory.common.period.infra.review_meta.PeerReviewMetaRepository;
import jjfactory.common.period.infra.review_meta.PerformanceReviewMetaRepository;
import jjfactory.common.period.infra.review_meta.TotalReviewMetaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReviewMetaReaderImpl implements ReviewMetaReader {
    private final TotalReviewMetaRepository totalReviewMetaRepository;
    private final PerformanceReviewMetaRepository performanceReviewMetaRepository;
    private final PeerReviewMetaRepository peerReviewMetaRepository;
    private final LeaderReviewMetaRepository leaderReviewMetaRepository;
    @Override
    public TotalReviewMeta get(Long id) {
        return totalReviewMetaRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("review not found");
        });
    }

    @Override
    public PeerReviewMeta getPeerReviewMeta(Long id) {
        return peerReviewMetaRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("review not found");
        });
    }

    @Override
    public LeaderReviewMeta getLeaderReviewMeta(Long id) {
        return leaderReviewMetaRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("review not found");
        });
    }

    @Override
    public PerformanceReviewMeta getPerformanceReviewMeta(Long id) {
        return performanceReviewMetaRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("review not found");
        });
    }
}
