package jjfactory.common.period.domain.year_quarter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class YearQuarterInfo {

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DetailResponse {
        private Long id;
        private int year;
        private int quarter;
        private boolean isOpen;

        private LocalDateTime startDt;
        private LocalDateTime endDt;
    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListResponse {
        private Long id;
        private int year;
        private int quarter;
        private boolean open;
    }
}
