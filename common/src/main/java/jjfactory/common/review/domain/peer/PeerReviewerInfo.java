package jjfactory.common.review.domain.peer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PeerReviewerInfo {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class ListResponse {
        private Long id;
        private Long metaId;
        private Long userId;
        private Long evaluatorId;
        private boolean isSubmitted;
        private PeerReviewer.CreationType type;
    }
}
