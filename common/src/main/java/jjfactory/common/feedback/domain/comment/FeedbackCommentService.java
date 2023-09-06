package jjfactory.common.feedback.domain.comment;

import java.util.List;

public interface FeedbackCommentService {
    List<FeedbackCommentInfo.ListResponse> getList(Long feedbackId);
    Long delete(Long commentId, Long userId);
    Long create(FeedbackCommentCommand.Create command, Long feedbackId, Long userId);
    Long update(Long commentId, FeedbackCommentCommand.Update command, Long userId);
    void like(Long commentId, Long userId);
}
