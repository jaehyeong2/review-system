package jjfactory.common.period.infra.year_quarter;

import jjfactory.common.global.exception.ResourceNotFoundException;
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
        return yearQuarterRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("yearQuarter not found");
        });
    }

    @Override
    public List<YearQuarter> getList() {
        return yearQuarterRepository.findAllByOrderByYearDescQuarterDesc();
    }
}
