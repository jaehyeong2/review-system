package jjfactory.common.review.domain.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

public class QuestionnaireCommand {
    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private String title;
        private String description;
        private long metaId;
        private Set<CreateCategory> categories = new HashSet();
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        private Long id;
        private String title;
        private String description;
        private Set<UpdateCategory> categories = new HashSet();
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateCategory {
        private String title;
        private String description;
        private int seq;
        private Set<CreateQuestion> questions = new HashSet();
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateCategory {
        private Long id;
        private String title;
        private String description;
        private int seq;
        private Set<UpdateQuestion> questions = new HashSet();
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateQuestion {
        private String content;
        private int seq;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateQuestion {
        private Long id;
        private String content;
        private int seq;
    }
}
