package jjfactory.admin.period.year_quarter.presentation.dto;

import jjfactory.common.period.domain.year_quarter.YearQuarterCommand;
import jjfactory.common.period.domain.year_quarter.YearQuarterInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface YearQuarterDtoMapper {
    YearQuarterCommand.Update of(YearQuarterDto.UpdateRequest request);
    YearQuarterDto.ListResponse of(YearQuarterInfo.ListResponse response);
}
