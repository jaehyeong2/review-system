package jjfactory.common.period.domain.review_meta;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class PerformanceReviewMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private TotalReviewMeta totalReviewMeta;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate evaluation1stStartDate;
    private LocalDate evaluation1stEndDate;
    private LocalDate evaluation2ndStartDate;
    private LocalDate evaluation2ndEndDate;
    private LocalDate reviewConfirmStartDate;
    private LocalDate reviewConfirmEndDate;
}
