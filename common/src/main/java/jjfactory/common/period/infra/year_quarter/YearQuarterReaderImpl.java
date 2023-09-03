package jjfactory.common.period.infra.year_quarter;

import jjfactory.common.period.domain.year_quarter.YearQuarter;
import jjfactory.common.period.domain.year_quarter.YearQuarterReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class YearQuarterReaderImpl implements YearQuarterReader {
    private final YearQuarterRepository yearQuarterRepository;

    @Override
    public YearQuarter get(Long id) {
        return yearQuarterRepository.findById(id).orElse(null);
    }

    @Override
    public List<YearQuarter> getList() {
        return yearQuarterRepository.findAllByOrderByYearDescQuarterDesc();
    }
}
