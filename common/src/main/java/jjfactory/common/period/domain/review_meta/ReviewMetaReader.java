package jjfactory.common.period.domain.review_meta;

public interface ReviewMetaReader {
    TotalReviewMeta get(Long id);
    PeerReviewMeta getPeerReviewMeta(Long id);
    LeaderReviewMeta getLeaderReviewMeta(Long id);
    PerformanceReviewMeta getPerformanceReviewMeta(Long id);
}
