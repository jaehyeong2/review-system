package jjfactory.common.period.infra.year_quarter;

import jjfactory.common.period.domain.year_quarter.YearQuarter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YearQuarterRepository extends JpaRepository<YearQuarter, Long> {
    List<YearQuarter> findAllByOrderByYearDescQuarterDesc();
    void deleteAllByYear(int year);
}
