package jjfactory.common.notification.domain;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class NotificationServiceImpl implements NotificationService {
    private final NotificationReader notificationReader;
    private final NotificationWriter notificationWriter;

    @Transactional
    @Override
    public Long createFeedbackNotification(Long receiverUserId, Long sendUserId) {
        Notification notification = Notification.create(sendUserId, receiverUserId, NotificationType.FEEDBACK);

        return notificationWriter.write(notification).getId();
    }
}
