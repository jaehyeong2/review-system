package jjfactory.common.year_quarter.infra;

import jjfactory.common.year_quarter.domain.YearQuarter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearQuarterRepository extends JpaRepository<YearQuarter, Long> {
}
