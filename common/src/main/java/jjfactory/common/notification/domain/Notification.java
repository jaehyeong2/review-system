package jjfactory.common.notification.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long receiveUserId;
    private Long sendUserId;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    private boolean hasRead;
    @CreationTimestamp
    private LocalDateTime createDt;

}
