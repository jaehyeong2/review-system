package jjfactory.api.review.presentation.peer.dto;

import jjfactory.common.review.domain.peer.PeerReviewerInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeerReviewDtoMapper {
    PeerReviewerDto.ListResponse of(PeerReviewerInfo.ListResponse response);
}
