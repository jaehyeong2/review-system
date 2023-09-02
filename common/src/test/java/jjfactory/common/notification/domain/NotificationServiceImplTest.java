package jjfactory.common.notification.domain;

import jjfactory.common.notification.infra.NotificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NotificationServiceImplTest {
    @Autowired
    NotificationService notificationService;
    @Autowired
    NotificationRepository notificationRepository;

    @BeforeEach
    void setUp() {
        notificationRepository.deleteAll();
    }

    @Test
    @DisplayName("알림 생성 성공")
    void createFeedbackNotification() {
        //when
        Long notificationId = notificationService.createFeedbackNotification(32L, 18L);

        //then
        assertThat(notificationId).isNotNull();
    }

    @Test
    @DisplayName("알림 조회 성공")
    void getListByReceiveUserId() {
        //given
        Notification noti = Notification.builder()
                .receiveUserId(18L)
                .sendUserId(20L)
                .build();

        Notification noti2 = Notification.builder()
                .receiveUserId(18L)
                .sendUserId(22L)
                .build();

        notificationRepository.save(noti);
        notificationRepository.save(noti2);

        //when
        List<NotificationInfo.ListResponse> result = notificationService.getListByReceiveUserId(18L);

        //then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void readOne() {
//        notificationService.readOne();
    }

    @Test
    void readAll() {
//        notificationService.readAll();
    }
}