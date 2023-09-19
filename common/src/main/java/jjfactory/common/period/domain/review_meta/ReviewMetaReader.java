package jjfactory.common.period.domain.review_meta;

public interface ReviewMetaReader {
    TotalReviewMeta get(Long id);
    PeerReviewMeta getPeerReviewMeta(Long id);
    LeadershipReviewMeta getLeaderReviewMeta(Long id);
    SelfReviewMeta getSelfReviewMeta(Long id);
}
