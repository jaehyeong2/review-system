package jjfactory.common.review.domain.question;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionnaireMapper {
    QuestionnaireInfo.ListResponse ofListResponse(Questionnaire questionnaire);
    QuestionnaireInfo.DetailResponse of(Questionnaire questionnaire);

    QuestionnaireInfo.CategoryInfo of(Category category);
    QuestionnaireInfo.QuestionInfo of(Question question);

}
