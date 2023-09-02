package jjfactory.common.notification.domain;

import java.util.List;

public interface NotificationReader {
    Notification get(Long id);

    List<Notification> getListByReceiveUserId(Long receiveUserId);

}
