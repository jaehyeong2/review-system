package jjfactory.common.review.domain.question;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    private int seq;
    private String content;
    @Enumerated(EnumType.STRING)
    private Type type;
    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    public enum Type {
        SUBJECTIVE, OBJECTIVE
    }

    @Builder
    public Question(Category category, int seq, String content, Type type) {
        this.category = category;
        this.seq = seq;
        this.content = content;
        this.type = type;
    }

    public void update(String content, Type type, int seq) {
        this.content = content;
        this.type = type;
        this.seq = seq;
    }
}

