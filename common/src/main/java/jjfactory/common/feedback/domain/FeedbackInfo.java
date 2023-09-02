package jjfactory.common.feedback.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FeedbackInfo {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailResponse {
        private Long id;
        private Long sendUserId;
        private Long receiveUserId;
        private String content;
        private Feedback.Type type;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListResponse {
        private Long id;
        private Long sendUserId;
        private Long receiveUserId;
        private String content;
        private Feedback.Type type;
    }
}
