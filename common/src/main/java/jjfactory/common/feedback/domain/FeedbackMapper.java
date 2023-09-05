package jjfactory.common.feedback.domain;

import jjfactory.common.feedback.domain.comment.FeedbackComment;
import jjfactory.common.feedback.domain.comment.FeedbackCommentInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface FeedbackMapper {
    FeedbackInfo.DetailResponse of(Feedback feedback);
    FeedbackCommentInfo.ListResponse ofListResponse(FeedbackComment comment);
    FeedbackInfo.ListResponse ofListResponse(Feedback feedback);


}
