package jjfactory.common.notification.infra;

import jjfactory.common.notification.domain.Notification;
import jjfactory.common.notification.domain.NotificationReader;
import jjfactory.common.notification.infra.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class NotificationReaderImpl implements NotificationReader {
    private final NotificationRepository notificationRepository;
    @Override
    public Notification get(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Notification> getListByReceiveUserId(Long receiveUserId) {
        return notificationRepository.findAllByReceiveUserId(receiveUserId);
    }
}
