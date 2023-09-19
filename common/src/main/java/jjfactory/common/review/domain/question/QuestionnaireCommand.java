package jjfactory.common.review.domain.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        private Set<CreateCategory> categories;

        public Questionnaire toEntity(){
            return Questionnaire.builder()
                    .title(title)
                    .description(description)
                    .metaId(metaId)
                    .build();
        }
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        private String title;
        private String description;
        private Set<UpdateCategory> categories;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateCategory {
        private String title;
        private String description;
        private int seq;
        private Set<CreateQuestion> questions;

        public Category toEntity(Questionnaire questionnaire){
            return Category.builder()
                    .title(title)
                    .questionnaire(questionnaire)
                    .description(description)
                    .seq(seq)
                    .build();
        }
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
        private Set<UpdateQuestion> questions;

        public Category toEntity(Questionnaire questionnaire){
            return Category.builder()
                    .title(title)
                    .questionnaire(questionnaire)
                    .description(description)
                    .seq(seq)
                    .build();
        }
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateQuestion {
        private String content;
        private int seq;
        private Question.Type type;

        public Question toEntity(Category category){
            return Question.builder()
                    .category(category)
                    .seq(seq)
                    .type(type)
                    .content(content)
                    .build();
        }
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateQuestion {
        private Long id;
        private String content;
        private int seq;
        private Question.Type type;

        public Question toEntity(Category category){
            return Question.builder()
                    .category(category)
                    .seq(seq)
                    .type(type)
                    .content(content)
                    .build();
        }
    }
}
