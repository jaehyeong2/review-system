package jjfactory.common.user.domain;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserInfo.DetailResponse of(User user);
}
