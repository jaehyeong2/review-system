package jjfactory.common.notification.domain;

import java.util.List;

public interface NotificationService {
    Long createFeedbackNotification(Long receiverUserId, Long sendUserId);

    List<NotificationInfo.ListResponse> getListByReceiveUserId(Long receiveUserId);

    Long readOne(Long id);

    void readAll(Long userId);
}
