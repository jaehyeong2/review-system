package jjfactory.common.period.domain.review_meta;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Where(clause = "is_deleted is false")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class PerformanceReviewMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private TotalReviewMeta totalReviewMeta;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate evaluation1stStartDate;
    private LocalDate evaluation1stEndDate;
    private LocalDate evaluation2ndStartDate;
    private LocalDate evaluation2ndEndDate;
    private LocalDate reviewConfirmStartDate;
    private LocalDate reviewConfirmEndDate;
    private boolean isDeleted;

    public void delete() {
        isDeleted = true;
    }
}
