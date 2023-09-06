package jjfactory.api.feedback.application;

import jjfactory.common.feedback.domain.FeedbackCommand;
import jjfactory.common.feedback.domain.FeedbackInfo;
import jjfactory.common.feedback.domain.FeedbackService;
import jjfactory.common.notification.domain.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedbackFacade {
    private final FeedbackService feedbackService;
    private final NotificationService notificationService;

    public Long createFeedback(FeedbackCommand.Create command, Long receiverUserId, Long sendUserId) {
        Long feedbackId = feedbackService.create(command, sendUserId, receiverUserId);
        notificationService.createFeedbackNotification(receiverUserId, sendUserId);

        return feedbackId;
    }

    public List<FeedbackInfo.ListResponse> getList(Long receiveUserId) {
        return feedbackService.getList(receiveUserId);
    }

    public Long update(Long feedbackId, FeedbackCommand.Update command) {
        return feedbackService.update(feedbackId, command);
    }

    public Long delete(Long feedbackId) {
        return feedbackService.delete(feedbackId);
    }

    public void likeFeedback(Long feedbackId, Long userId) {
        feedbackService.like(feedbackId, userId);
    }
}
