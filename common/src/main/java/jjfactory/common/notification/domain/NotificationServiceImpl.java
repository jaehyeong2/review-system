package jjfactory.common.notification.domain;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class NotificationServiceImpl implements NotificationService {
    private final NotificationReader notificationReader;
    private final NotificationWriter notificationWriter;
    private final NotificationMapper notificationMapper;

    @Transactional
    @Override
    public Long createFeedbackNotification(Long receiverUserId, Long sendUserId) {
        Notification notification = Notification.create(sendUserId, receiverUserId, NotificationType.FEEDBACK);
        return notificationWriter.write(notification).getId();
    }

    @Transactional(readOnly = true)
    @Override
    public List<NotificationInfo.ListResponse> getListByReceiveUserId(Long receiveUserId){
        return notificationReader.getListByReceiveUserId(receiveUserId)
                .stream().map(notificationMapper::ofListResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Long readOne(Long id){
        Notification notification = notificationReader.get(id);
        notification.read();

        return notification.getId();
    }

    @Transactional
    @Override
    public void readAll(Long userId){
        notificationReader.getListByReceiveUserId(userId).forEach(Notification::read);
    }
}
