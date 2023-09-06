package jjfactory.api.feedback.presentation.dto;

import jjfactory.common.feedback.domain.FeedbackCommand;
import jjfactory.common.feedback.domain.FeedbackInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedbackDtoMapper {
    FeedbackCommand.Create of(FeedbackDto.CreateRequest request);
    FeedbackDto.ListResponse of(FeedbackInfo.ListResponse response);

    FeedbackCommand.Update of(FeedbackDto.UpdateRequest request);
}
