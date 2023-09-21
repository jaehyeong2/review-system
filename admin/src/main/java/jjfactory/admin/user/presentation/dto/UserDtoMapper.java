package jjfactory.admin.user.presentation.dto;

import jjfactory.common.user.domain.UserInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    UserDto.DetailResponse of(UserInfo.DetailResponse response);
    UserDto.ListResponse of(UserInfo.ListResponse response);
}
