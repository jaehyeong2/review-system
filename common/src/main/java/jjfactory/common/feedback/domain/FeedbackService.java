package jjfactory.common.feedback.domain;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FeedbackService {
    Long create(FeedbackCommand.Create command, Long sendUserId, Long receiverId);
    Long delete(Long feedbackId);
    FeedbackInfo.DetailResponse get(Long id);
    List<FeedbackInfo.ListResponse> getList(Long loginUserId);
    Long update(Long feedbackId, FeedbackCommand.Update command);
}
