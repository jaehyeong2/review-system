package jjfactory.common.period.domain.review_meta;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class PeerReviewMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private TotalReviewMeta totalReviewMeta;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate addTargetStartDate;
    private LocalDate addTargetEndDate;
    private LocalDate addTargetByEvaluatorStartDate;
    private LocalDate addTargetByEvaluatorEndDate;
}
