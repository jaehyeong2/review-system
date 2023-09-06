package jjfactory.api.feedback.presentation.dto;

import jjfactory.common.feedback.domain.Feedback;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FeedbackDto {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateRequest {
        private String content;
        private Long receiverUserId;
        private Feedback.Type type;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateRequest {
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
        private int likeCount;
    }
}
