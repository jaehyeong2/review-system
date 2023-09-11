package jjfactory.api.review.presentation.peer.dto;

import jjfactory.common.review.domain.peer.PeerReviewer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PeerReviewerDto {
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
