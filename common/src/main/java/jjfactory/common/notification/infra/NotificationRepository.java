package jjfactory.common.notification.infra;

import jjfactory.common.notification.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findAllByReceiveUserId(Long receiveUserId);
}
