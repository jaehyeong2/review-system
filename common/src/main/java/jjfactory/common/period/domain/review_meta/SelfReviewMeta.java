package jjfactory.common.period.domain.review_meta;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.Objects;

@Where(clause = "is_deleted is false")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class SelfReviewMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private TotalReviewMeta totalReviewMeta;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate firstEvalStartDate;
    private LocalDate firstEvalEndDate;
    private LocalDate finalEvalStartDate;
    private LocalDate finalEvalEndDate;
    private boolean isDeleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelfReviewMeta that = (SelfReviewMeta) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void delete() {
        isDeleted = true;
    }

    @Builder
    public SelfReviewMeta(TotalReviewMeta totalReviewMeta, LocalDate startDate, LocalDate endDate, LocalDate firstEvalStartDate, LocalDate firstEvalEndDate, LocalDate finalEvalStartDate, LocalDate finalEvalEndDate) {
        this.totalReviewMeta = totalReviewMeta;
        this.startDate = startDate;
        this.endDate = endDate;
        this.firstEvalStartDate = firstEvalStartDate;
        this.firstEvalEndDate = firstEvalEndDate;
        this.finalEvalStartDate = finalEvalStartDate;
        this.finalEvalEndDate = finalEvalEndDate;
    }
}
