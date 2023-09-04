package jjfactory.common.review.domain.peer;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class PeerReviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long metaId;

    private Long receiveUserId;
    private Long sendUserId;

    private boolean isSubmitted;

    @Enumerated(EnumType.STRING)
    private CreationType type;

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    public void submit() {
        isSubmitted = true;
    }

    @AllArgsConstructor
    public enum CreationType {
        TEAM("팀원 자동 생성"),
        BY_EVALUATOR("평가자 신청"),
        ADMIN("관리자 등록");

        private String description;
    }

}
