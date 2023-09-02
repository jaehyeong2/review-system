package jjfactory.common.year_quarter.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 분기 정보
 */
@Data
@Entity
public class YearQuarter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 연도
     */
    private int year;
    /**
     * 분기
     */
    private int quarter;

    private boolean isOpen;

    private LocalDateTime startAt;
    private LocalDateTime endAt;
}
