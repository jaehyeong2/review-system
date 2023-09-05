package jjfactory.common.feedback.domain.comment;

import java.util.List;

public interface FeedbackCommentReader {
    FeedbackComment get(Long id);
    List<FeedbackComment> getComments(Long feedbackId);
}
