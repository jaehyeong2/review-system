package jjfactory.common.notification.domain;

import jakarta.persistence.*;
import jjfactory.common.feedback.domain.Feedback;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.Objects;

@Where(clause = "has_read is false")
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
    private LocalDateTime readDt;
    @CreationTimestamp
    private LocalDateTime createDt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Builder
    public Notification(Long receiveUserId, Long sendUserId, NotificationType type, boolean hasRead, LocalDateTime createDt) {
        this.receiveUserId = receiveUserId;
        this.sendUserId = sendUserId;
        this.type = type;
        this.hasRead = hasRead;
        this.createDt = createDt;
    }

    public static Notification create(Long sendUserId, Long receiveUserId, NotificationType type){
        return Notification
                .builder()
                .receiveUserId(receiveUserId)
                .sendUserId(sendUserId)
                .type(type)
                .build();
    }

    public void read(){
        this.hasRead = true;
        this.readDt = LocalDateTime.now();
    }
}
