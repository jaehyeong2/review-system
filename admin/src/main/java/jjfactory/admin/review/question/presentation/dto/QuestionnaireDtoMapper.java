package jjfactory.admin.review.question.presentation.dto;

import jjfactory.common.review.domain.question.QuestionnaireInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionnaireDtoMapper {
    QuestionnaireDto.ListResponse of(QuestionnaireInfo.ListResponse response);
    QuestionnaireDto.DetailResponse of(QuestionnaireInfo.DetailResponse response);
}
