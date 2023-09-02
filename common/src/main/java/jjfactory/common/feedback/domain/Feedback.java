package jjfactory.common.feedback.domain;

import jakarta.persistence.*;
import jjfactory.common.feedback.domain.comment.FeedbackComment;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "feedback", cascade = CascadeType.REMOVE)
    private final List<FeedbackComment> comments = new ArrayList<>();

    private Long sendUserId;
    private Long receiveUserId;

    private String content;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {

    }

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;


    @Builder
    public Feedback(Long sendUserId, Long receiveUserId, String content, Type type) {
        this.sendUserId = sendUserId;
        this.receiveUserId = receiveUserId;
        this.content = content;
        this.type = type;
    }

    public void update(String content, Type type) {
        if (StringUtils.hasText(content)) this.content = content;
        this.type = type;
    }
}
