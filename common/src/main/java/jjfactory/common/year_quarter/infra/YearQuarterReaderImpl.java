package jjfactory.common.year_quarter.infra;

import jjfactory.common.year_quarter.domain.YearQuarter;
import jjfactory.common.year_quarter.domain.YearQuarterReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class YearQuarterReaderImpl implements YearQuarterReader {
    private final YearQuarterRepository yearQuarterRepository;

    @Override
    public YearQuarter get(Long id) {
        return yearQuarterRepository.findById(id).orElse(null);
    }
}
