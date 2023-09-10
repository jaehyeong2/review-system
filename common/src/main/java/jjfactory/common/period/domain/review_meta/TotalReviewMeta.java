package jjfactory.common.period.domain.review_meta;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class TotalReviewMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;
}
