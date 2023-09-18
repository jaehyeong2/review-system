package jjfactory.common.period.domain.review_meta;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Where(clause = "is_deleted is false")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class TotalReviewMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "totalReviewMeta")
    private PeerReviewMeta peerReviewMeta;
    @OneToOne(mappedBy = "totalReviewMeta")
    private PerformanceReviewMeta performanceReviewMeta;
    @OneToOne(mappedBy = "totalReviewMeta")
    private LeaderReviewMeta leaderReviewMeta;
    private String name;
    @Comment("동료 리뷰 포함여부")
    private boolean reviewPeerIncluded;
    @Comment("리더십 리뷰 포함여부")
    private boolean reviewLeaderIncluded;
    @Comment("성과 리뷰 포함여부")
    private boolean reviewSelfIncluded;
    @Comment("리뷰 탭 공개일")
    private LocalDate showMenuDate;
    @Comment("리뷰 탭 숨김일")
    private LocalDate hideMenuDate;
    @Comment("리뷰 결과 공개일")
    private LocalDate showResultDate;
    private long yearQuarterId;
    private boolean isDeleted;

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    @Builder
    public TotalReviewMeta(String name, boolean reviewPeerIncluded, boolean reviewLeaderIncluded, boolean reviewSelfIncluded, LocalDate showMenuDate, LocalDate hideMenuDate, LocalDate showResultDate, long yearQuarterId) {
        this.name = name;
        this.reviewPeerIncluded = reviewPeerIncluded;
        this.reviewLeaderIncluded = reviewLeaderIncluded;
        this.reviewSelfIncluded = reviewSelfIncluded;
        this.showMenuDate = showMenuDate;
        this.hideMenuDate = hideMenuDate;
        this.showResultDate = showResultDate;
        this.yearQuarterId = yearQuarterId;
    }

    public void delete(){
        isDeleted = true;
        performanceReviewMeta.delete();
        peerReviewMeta.delete();
        leaderReviewMeta.delete();
    }

}
