package jjfactory.common.review.domain.question;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Questionnaire questionnaire;
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Question> questions = new ArrayList<>();
    private String title;
    private String description;
    private int seq;
    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    @Builder
    public Category(Questionnaire questionnaire, String title, String description, int seq) {
        this.questionnaire = questionnaire;
        this.title = title;
        this.description = description;
        this.seq = seq;
    }

    public void update(String title, String description, int seq) {
        this.title = title;
        this.description = description;
        this.seq = seq;
    }
}
