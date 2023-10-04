package jjfactory.common.feedback.domain.like;

import jakarta.persistence.*;
import jjfactory.common.feedback.domain.Feedback;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class FeedbackLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Feedback feedback;
    private Long userId;

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackLike that = (FeedbackLike) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Builder
    public FeedbackLike(Feedback feedback, Long userId) {
        this.feedback = feedback;
        this.userId = userId;
    }

    public static FeedbackLike create(Feedback feedback, Long userId){
        return FeedbackLike.builder()
                .feedback(feedback)
                .userId(userId)
                .build();
    }
}
