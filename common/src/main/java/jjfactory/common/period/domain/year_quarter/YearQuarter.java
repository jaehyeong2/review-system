package jjfactory.common.period.domain.year_quarter;

import jakarta.persistence.*;
import jjfactory.common.feedback.domain.Feedback;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class YearQuarter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "year_value")
    private int year;
    @Column(name = "quarter_value")
    private int quarter;

    private boolean isOpen;

    private LocalDateTime startDt;
    private LocalDateTime endDt;

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearQuarter that = (YearQuarter) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Builder
    public YearQuarter(int year, int quarter, boolean isOpen, LocalDateTime startDt, LocalDateTime endDt) {
        this.year = year;
        this.quarter = quarter;
        this.isOpen = isOpen;
        this.startDt = startDt;
        this.endDt = endDt;
    }

    public void update(int year, int quarter, LocalDateTime startDt, LocalDateTime endDt){
        this.year = year;
        this.quarter = quarter;
        this.startDt = startDt;
        this.endDt = endDt;
    }

    public void open(){
        this.isOpen = true;
    }

    public void close(){
        this.isOpen = false;
    }
}
