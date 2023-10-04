package jjfactory.common.period.domain.review_meta;

import jakarta.persistence.*;
import jjfactory.common.feedback.domain.Feedback;
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
public class LeadershipReviewMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private TotalReviewMeta totalReviewMeta;
    private LocalDate startDate;
    private LocalDate endDate;

    private boolean isDeleted;

    public void delete() {
        isDeleted = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeadershipReviewMeta that = (LeadershipReviewMeta) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Builder
    public LeadershipReviewMeta(TotalReviewMeta totalReviewMeta, LocalDate startDate, LocalDate endDate) {
        this.totalReviewMeta = totalReviewMeta;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
