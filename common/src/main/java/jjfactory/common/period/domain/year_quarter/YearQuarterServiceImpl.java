package jjfactory.common.period.domain.year_quarter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class YearQuarterServiceImpl implements YearQuarterService {
    private final YearQuarterReader yearQuarterReader;
    private final YearQuarterWriter yearQuarterWriter;
    private final YearQuarterMapper yearQuarterMapper;

    @Transactional(readOnly = true)
    @Override
    public List<YearQuarterInfo.ListResponse> getAllYearQuarters() {
        return yearQuarterReader.getList().stream()
                .map(yearQuarterMapper::ofListResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteByYear(int year) {
        yearQuarterWriter.deleteByYear(year);
    }

    @Transactional
    @Override
    public List<Long> updateYearQuarters(List<YearQuarterCommand.Update> commands) {
        return commands.stream().map(e -> {
            YearQuarter yearQuarter = yearQuarterReader.get(e.getId());
            yearQuarter.update(e.getYear(), e.getQuarter(), e.getStartDt(), e.getEndDt());

            return e.getId();
        }).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void openYearQuarters(List<Long> ids){
        ids.forEach(id -> {
            yearQuarterReader.get(id).open();
        });
    }

    @Transactional
    @Override
    public void closeYearQuarters(List<Long> ids){
        ids.forEach(id -> {
            yearQuarterReader.get(id).close();
        });
    }
}
