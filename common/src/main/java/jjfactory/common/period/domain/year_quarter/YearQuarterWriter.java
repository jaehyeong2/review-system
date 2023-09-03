package jjfactory.common.period.domain.year_quarter;

import java.util.List;

public interface YearQuarterWriter {
    YearQuarter write(YearQuarter yearQuarter);
    void deleteByYear(int year);
}
