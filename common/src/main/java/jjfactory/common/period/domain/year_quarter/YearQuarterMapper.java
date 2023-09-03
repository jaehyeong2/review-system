package jjfactory.common.period.domain.year_quarter;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface YearQuarterMapper {
    YearQuarterInfo.ListResponse ofListResponse(YearQuarter yearQuarter);
    YearQuarterInfo.DetailResponse of(YearQuarter yearQuarter);

}
