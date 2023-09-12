package jjfactory.common.review.domain.question;


import jakarta.persistence.*;
import jjfactory.common.review.domain.ReviewType;
import lombok.AccessLevel;
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

    public enum Status {
        OPEN, TEMP
    }
    public void open(){
        status = Status.OPEN;
    }
}
