package jjfactory.common.notification.infra;

import jjfactory.common.notification.domain.Notification;
import jjfactory.common.notification.domain.NotificationWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NotificationWriterImpl implements NotificationWriter {
    private final NotificationRepository notificationRepository;

    @Override
    public Notification write(Notification notification) {
        return notificationRepository.save(notification);
    }
}
