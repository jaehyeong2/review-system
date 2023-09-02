package jjfactory.common.notification.domain;

public interface NotificationService {
    Long createFeedbackNotification(Long receiverUserId, Long sendUserId);
}
