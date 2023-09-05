package jjfactory.common.feedback.domain.comment;

import jjfactory.common.feedback.domain.Feedback;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FeedbackCommentCommand {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private String content;

        public FeedbackComment toEntity(Feedback feedback, Long userId){
            return FeedbackComment.builder()
                    .feedback(feedback)
                    .userId(userId)
                    .content(content)
                    .build();
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        private Long feedbackId;
        private String content;
    }
}
