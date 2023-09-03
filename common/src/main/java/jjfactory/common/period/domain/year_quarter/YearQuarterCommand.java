package jjfactory.common.period.domain.year_quarter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class YearQuarterCommand {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Update{
        private Long id;
        private int year;
        private int quarter;
        private LocalDateTime startDt;
        private LocalDateTime endDt;
    }
}
