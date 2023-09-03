package jjfactory.common.period.domain.year_quarter;

import java.util.List;

public interface YearQuarterReader {
    YearQuarter get(Long id);
    List<YearQuarter> getList();
}
