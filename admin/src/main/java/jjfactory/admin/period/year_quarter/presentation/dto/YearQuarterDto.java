package jjfactory.admin.period.year_quarter.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class YearQuarterDto {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UpdateRequest {
        private Long id;
        private int year;
        private int quarter;
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
        @JsonProperty("isOpen")
        private boolean open;
    }
}
