package jjfactory.common.year_quarter.infra;

import jjfactory.common.year_quarter.domain.YearQuarter;
import jjfactory.common.year_quarter.domain.YearQuarterWriter;
import jjfactory.common.year_quarter.infra.YearQuarterRepository;
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
