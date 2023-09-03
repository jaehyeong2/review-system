package jjfactory.admin.period.year_quarter.application;

import jjfactory.common.period.domain.year_quarter.YearQuarterCommand;
import jjfactory.common.period.domain.year_quarter.YearQuarterInfo;
import jjfactory.common.period.domain.year_quarter.YearQuarterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class YearQuarterFacade {
    private final YearQuarterService yearQuarterService;

    public List<YearQuarterInfo.ListResponse> getAllYearQuarters(){
        return yearQuarterService.getAllYearQuarters();
    }

    public void deleteByYear(int year){
        yearQuarterService.deleteByYear(year);
    }

    public List<Long> updateYearQuarters(List<YearQuarterCommand.Update> commands){
        return yearQuarterService.updateYearQuarters(commands);
    }

    public void openYearQuarters(List<Long> ids){
        yearQuarterService.openYearQuarters(ids);
    }

    public void closeYearQuarters(List<Long> ids){
        yearQuarterService.closeYearQuarters(ids);
    }
}
