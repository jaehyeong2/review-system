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
        private boolean reviewPeerIncluded;
        private boolean reviewLeaderIncluded;
        private boolean reviewSelfIncluded;
        private LocalDate showMenuDate;
        private LocalDate hideMenuDate;
        private LocalDate showResultDate;
        private long yearQuarterId;

        public TotalReviewMeta toEntity(){
            return TotalReviewMeta.builder()
                    .name(name)
                    .reviewPeerIncluded(reviewPeerIncluded)
                    .reviewLeaderIncluded(reviewLeaderIncluded)
                    .reviewSelfIncluded(reviewSelfIncluded)
                    .showMenuDate(showMenuDate)
                    .hideMenuDate(hideMenuDate)
                    .showResultDate(showResultDate)
                    .build();
        }
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Update {

    }

}
