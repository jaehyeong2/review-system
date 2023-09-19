package jjfactory.common.period.domain.review_meta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ReviewMetaInfo {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class ListResponse{
        private Long id;
        private String name;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class DetailResponse{
        private Long id;
    }

}
