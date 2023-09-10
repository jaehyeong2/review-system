package jjfactory.common.review.domain.peer;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeerReviewerMapper {
    PeerReviewerInfo.ListResponse of(PeerReviewer peerReviewer);
}
