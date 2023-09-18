package jjfactory.common.period.domain.review_meta;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Where(clause = "is_deleted is false")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class PeerReviewMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private TotalReviewMeta totalReviewMeta;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate addTargetStartDate;
    private LocalDate addTargetEndDate;
    private LocalDate addTargetByEvaluatorStartDate;
    private LocalDate addTargetByEvaluatorEndDate;

    private boolean isDeleted;

    @Builder
    public PeerReviewMeta(TotalReviewMeta totalReviewMeta, LocalDate startDate, LocalDate endDate, LocalDate addTargetStartDate, LocalDate addTargetEndDate, LocalDate addTargetByEvaluatorStartDate, LocalDate addTargetByEvaluatorEndDate) {
        this.totalReviewMeta = totalReviewMeta;
        this.startDate = startDate;
        this.endDate = endDate;
        this.addTargetStartDate = addTargetStartDate;
        this.addTargetEndDate = addTargetEndDate;
        this.addTargetByEvaluatorStartDate = addTargetByEvaluatorStartDate;
        this.addTargetByEvaluatorEndDate = addTargetByEvaluatorEndDate;
    }

    public void delete() {
        isDeleted = true;
    }
}
