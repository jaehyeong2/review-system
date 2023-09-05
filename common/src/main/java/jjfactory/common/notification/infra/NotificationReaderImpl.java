package jjfactory.common.notification.infra;

import jjfactory.common.global.exception.ResourceNotFoundException;
import jjfactory.common.notification.domain.Notification;
import jjfactory.common.notification.domain.NotificationReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class NotificationReaderImpl implements NotificationReader {
    private final NotificationRepository notificationRepository;

    @Override
    public Notification get(Long id) {
        return notificationRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("notification not found");
        });
    }

    @Override
    public List<Notification> getListByReceiveUserId(Long receiveUserId) {
        return notificationRepository.findAllByReceiveUserId(receiveUserId);
    }
}
