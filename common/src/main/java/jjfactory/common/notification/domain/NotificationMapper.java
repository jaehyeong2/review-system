package jjfactory.common.notification.domain;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationInfo.ListResponse ofListResponse(Notification notification);
}
