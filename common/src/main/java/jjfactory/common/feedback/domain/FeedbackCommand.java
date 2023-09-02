package jjfactory.common.feedback.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FeedbackCommand {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private String content;
        private Feedback.Type type;

        public Feedback toEntity(Long sendUserId, Long receiverId) {
            return Feedback.builder()
                    .content(content)
                    .type(type)
                    .sendUserId(sendUserId)
                    .receiveUserId(receiverId)
                    .build();
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        private String content;
        private Feedback.Type type;
    }
}
