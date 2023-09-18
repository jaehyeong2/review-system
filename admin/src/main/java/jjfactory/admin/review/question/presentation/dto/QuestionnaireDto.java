package jjfactory.admin.review.question.presentation.dto;

import jjfactory.common.review.domain.question.Question;
import jjfactory.common.review.domain.question.Questionnaire;
import jjfactory.common.review.domain.question.QuestionnaireInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QuestionnaireDto {
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
        private List<QuestionnaireInfo.CategoryInfo> categories = new ArrayList<>();
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CategoryResponse {
        private Long id;
        private String title;
        private String description;
        private int seq;
        private List<QuestionnaireInfo.QuestionInfo> questions = new ArrayList<>();
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class QuestionResponse {
        private Long id;
        private String content;
        private Question.Type type;
        private int seq;
    }
}
