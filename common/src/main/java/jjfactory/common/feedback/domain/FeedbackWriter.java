package jjfactory.common.feedback.domain;

import jjfactory.common.feedback.domain.comment.FeedbackComment;

public interface FeedbackWriter {
    Feedback write(Feedback feedback);
    FeedbackComment writeComment(FeedbackComment feedbackComment);
    Long deleteById(Long feedbackId);
}
