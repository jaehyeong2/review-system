package jjfactory.common.notification.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class NotificationInfo {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListResponse{
        private Long id;
        private Long sendUserId;
        private NotificationType type;
        private LocalDateTime createDt;
    }
}
