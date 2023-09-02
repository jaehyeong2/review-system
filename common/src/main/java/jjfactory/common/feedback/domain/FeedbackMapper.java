package jjfactory.common.feedback.domain;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface FeedbackMapper {
    FeedbackInfo.DetailResponse of(Feedback feedback);

    FeedbackInfo.ListResponse ofListResponse(Feedback feedback);

}
