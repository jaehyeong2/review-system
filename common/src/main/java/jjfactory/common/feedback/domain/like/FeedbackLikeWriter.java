package jjfactory.common.feedback.domain.like;

public interface FeedbackLikeWriter {
    FeedbackLike write(FeedbackLike feedbackLike);
    Long delete(Long id);
}
