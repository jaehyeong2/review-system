package jjfactory.common.period.domain.review_meta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class ReviewMetaCommand {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Create {
        private String name;
        private boolean peerIncluded;
        private boolean leadershipIncluded;
        private boolean selfIncluded;
        private LocalDate showMenuDate;
        private LocalDate hideMenuDate;
        private LocalDate showResultDate;
        private long yearQuarterId;
        private CreatePeer peerReviewMata;
        private CreateSelf selfReviewMeta;
        private CreateLeadership leadershipReviewMeta;

        public TotalReviewMeta toEntity(){
            return TotalReviewMeta.builder()
                    .name(name)
                    .peerIncluded(peerIncluded)
                    .leadershipIncluded(leadershipIncluded)
                    .selfIncluded(selfIncluded)
                    .showMenuDate(showMenuDate)
                    .hideMenuDate(hideMenuDate)
                    .showResultDate(showResultDate)
                    .yearQuarterId(yearQuarterId)
                    .build();
        }
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Update {
        private Long id;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class CreatePeer {
        private LocalDate startDate;
        private LocalDate endDate;
        private LocalDate addTargetStartDate;
        private LocalDate addTargetEndDate;
        private LocalDate addTargetByEvaluatorStartDate;
        private LocalDate addTargetByEvaluatorEndDate;

        public PeerReviewMeta toEntity(TotalReviewMeta totalReviewMeta){
            return PeerReviewMeta.builder()
                    .totalReviewMeta(totalReviewMeta)
                    .startDate(startDate)
                    .endDate(endDate)
                    .addTargetStartDate(addTargetStartDate)
                    .addTargetEndDate(addTargetEndDate)
                    .addTargetByEvaluatorStartDate(addTargetByEvaluatorStartDate)
                    .addTargetByEvaluatorEndDate(addTargetByEvaluatorEndDate)
                    .build();
        }
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class CreateSelf {
        private LocalDate startDate;
        private LocalDate endDate;
        private LocalDate firstEvalStartDate;
        private LocalDate firstEvalEndDate;
        private LocalDate finalEvalStartDate;
        private LocalDate finalEvalEndDate;

        public SelfReviewMeta toEntity(TotalReviewMeta totalReviewMeta){
            return SelfReviewMeta.builder()
                    .totalReviewMeta(totalReviewMeta)
                    .startDate(startDate)
                    .endDate(endDate)
                    .firstEvalStartDate(firstEvalStartDate)
                    .finalEvalEndDate(finalEvalEndDate)
                    .finalEvalStartDate(finalEvalStartDate)
                    .finalEvalEndDate(firstEvalEndDate)
                    .build();
        }
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class CreateLeadership {
        private LocalDate startDate;
        private LocalDate endDate;

        public LeadershipReviewMeta toEntity(TotalReviewMeta totalReviewMeta){
            return LeadershipReviewMeta.builder()
                    .totalReviewMeta(totalReviewMeta)
                    .startDate(startDate)
                    .endDate(endDate)
                    .build();
        }
    }

}
