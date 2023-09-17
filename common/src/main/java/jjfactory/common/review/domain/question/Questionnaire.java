package jjfactory.common.review.domain.question;


import jakarta.persistence.*;
import jjfactory.common.review.domain.ReviewType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@DynamicUpdate
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "questionnaire", cascade = CascadeType.REMOVE)
    private List<Category> categories = new ArrayList<>();
    private long metaId;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private ReviewType reviewType;
    @Enumerated(EnumType.STRING)
    private Status status = Status.TEMP;
    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    @Builder
    public Questionnaire(long metaId, String title, String description, ReviewType reviewType, Status status) {
        this.metaId = metaId;
        this.title = title;
        this.description = description;
        this.reviewType = reviewType;
        this.status = status;
    }

    public enum Status {
        OPEN, TEMP
    }
    public void open(){
        status = Status.OPEN;
    }

    public void updateQuestionnaire(String title, String description) {
        if(StringUtils.hasText(title)) this.title = title;
        if(StringUtils.hasText(description)) this.description = description;
    }
}
