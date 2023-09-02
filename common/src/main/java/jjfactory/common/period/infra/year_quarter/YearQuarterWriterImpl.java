package jjfactory.common.period.infra.year_quarter;

import jjfactory.common.period.domain.year_quarter.YearQuarter;
import jjfactory.common.period.domain.year_quarter.YearQuarterWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class YearQuarterWriterImpl implements YearQuarterWriter {
    private final YearQuarterRepository yearQuarterRepository;

    @Override
    public YearQuarter write(YearQuarter yearQuarter) {
        return yearQuarterRepository.save(yearQuarter);
    }
}
