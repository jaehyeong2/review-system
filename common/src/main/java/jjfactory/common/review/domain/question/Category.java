package jjfactory.common.review.domain.question;


import jakarta.persistence.*;
import jjfactory.common.feedback.domain.Feedback;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category that = (Category) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

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
