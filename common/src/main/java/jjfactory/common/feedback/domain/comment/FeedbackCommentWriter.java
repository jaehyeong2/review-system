package jjfactory.common.feedback.domain.comment;

public interface FeedbackCommentWriter {
    FeedbackComment write(FeedbackComment feedbackComment);
    Long deleteByIdOrThrow(Long commentId);
    Long deleteById(Long commentId);
}
