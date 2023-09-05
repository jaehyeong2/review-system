package jjfactory.common.feedback.domain.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class FeedbackCommentInfo {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListResponse {
        private Long id;
        private Long sendUserId;
        private Long receiveUserId;
        private String content;
        private int likeCount;
        private LocalDateTime createDt;
        private LocalDateTime updateDt;
    }
}
