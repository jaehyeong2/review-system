package jjfactory.common.review.domain.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class QuestionnaireInfo {
    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListResponse {
        private Long id;
        private String title;
        private Questionnaire.Status status;
        private LocalDateTime createDt;
        private LocalDateTime updateDt;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailResponse {
        private Long id;
        private String description;
        private String title;
        private LocalDateTime createDt;
        private LocalDateTime updateDt;
        private List<CategoryInfo> categories;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CategoryInfo {
        private Long id;
        private String title;
        private String description;
        private int seq;
        private List<QuestionInfo> questions;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class QuestionInfo {
        private Long id;
        private String content;
        private Question.Type type;
        private int seq;
    }
}
