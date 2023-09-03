package jjfactory.common.period.domain.year_quarter;

import java.util.List;

public interface YearQuarterService {
    List<YearQuarterInfo.ListResponse> getAllYearQuarters();

    void deleteByYear(int year);

    List<Long> updateYearQuarters(List<YearQuarterCommand.Update> commands);

    void openYearQuarters(List<Long> ids);

    void closeYearQuarters(List<Long> ids);
}
