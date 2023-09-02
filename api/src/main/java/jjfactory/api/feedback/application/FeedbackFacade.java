package jjfactory.api.feedback.application;

import jjfactory.common.feedback.domain.FeedbackCommand;
import jjfactory.common.feedback.domain.FeedbackService;
import jjfactory.common.notification.domain.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FeedbackFacade {
    private final FeedbackService feedbackService;
    private final NotificationService notificationService;

    public Long createFeedback(FeedbackCommand.Create command, Long receiverUserId, Long sendUserId){
        Long feedbackId = feedbackService.create(command, sendUserId, receiverUserId);
        notificationService.createFeedbackNotification(receiverUserId, sendUserId);

        return feedbackId;
    }
}
