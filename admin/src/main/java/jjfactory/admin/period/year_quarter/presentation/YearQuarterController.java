package jjfactory.admin.period.year_quarter.presentation;

import jjfactory.admin.period.year_quarter.application.YearQuarterFacade;
import jjfactory.admin.period.year_quarter.presentation.dto.YearQuarterDto;
import jjfactory.admin.period.year_quarter.presentation.dto.YearQuarterDtoMapper;
import jjfactory.common.period.domain.year_quarter.YearQuarterCommand;
import jjfactory.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("year-quarters")
@RestController
@RequiredArgsConstructor
public class YearQuarterController {
    private final YearQuarterFacade yearQuarterFacade;
    private final YearQuarterDtoMapper yearQuarterDtoMapper;

    @GetMapping
    public CommonResponse<List<YearQuarterDto.ListResponse>> getAllYearQuarters() {
        return new CommonResponse<>(yearQuarterFacade.getAllYearQuarters().stream()
                .map(yearQuarterDtoMapper::of)
                .collect(Collectors.toList()));
    }

    @DeleteMapping
    public CommonResponse deleteByYear(@RequestParam int year) {
        yearQuarterFacade.deleteByYear(year);
        return CommonResponse.ok();
    }

    @PatchMapping
    public CommonResponse<List<Long>> updateYearQuarters(@RequestBody List<YearQuarterDto.UpdateRequest> requests) {
        List<YearQuarterCommand.Update> commands = requests.stream()
                .map(yearQuarterDtoMapper::of)
                .collect(Collectors.toList());

        return new CommonResponse<>(yearQuarterFacade.updateYearQuarters(commands));
    }

    @PatchMapping("/open")
    public CommonResponse openYearQuarters(@RequestParam List<Long> ids) {
        yearQuarterFacade.openYearQuarters(ids);
        return CommonResponse.ok();
    }

    @PatchMapping("/close")
    public CommonResponse closeYearQuarters(@RequestParam List<Long> ids) {
        yearQuarterFacade.closeYearQuarters(ids);
        return CommonResponse.ok();
    }
}
