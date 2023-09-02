package jjfactory.common.review.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ReviewAnswerSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long metaId;
    @Comment("작성자")
    private Long userId;
    @Comment("평가대상. 셀프리뷰일 경우 작성자와 동일")
    private Long receiveUserId;
    @Enumerated(EnumType.STRING)
    private ReviewType reviewType;
    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    @AllArgsConstructor
    public enum ReviewType{
        SELF("본인 성과 리뷰"),
        PEER("동료 리뷰"),
        LEADERSHIP("리더 리뷰");
        private String description;
    }

    public enum Status{
        TEMP, COMPLETE
    }
}
