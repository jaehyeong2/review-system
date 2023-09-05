package jjfactory.common.feedback.domain.comment.like;

public interface FeedbackCommentLikeWriter {
    FeedbackCommentLike write(FeedbackCommentLike feedbackCommentLike);

    Long deleteById(Long id);

    Long deleteByIdOrThrow(Long id);
}
