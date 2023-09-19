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

    @Builder
    public LeadershipReviewMeta(TotalReviewMeta totalReviewMeta, LocalDate startDate, LocalDate endDate) {
        this.totalReviewMeta = totalReviewMeta;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
