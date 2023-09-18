package jjfactory.common.period.domain.review_meta;

import java.util.List;

public interface ReviewMetaService {
    Long deleteTotalReviewMeta(Long id);

    Long modifyTotalReviewMeta(Long id, ReviewMetaCommand.Update command);

    Long createTotalReviewMeta(ReviewMetaCommand.Create command);

    List<ReviewMetaInfo.ListResponse> getList();

    ReviewMetaInfo.DetailResponse get(Long id);

    ReviewMetaInfo.DetailResponse getLastMeta(Long id);
}
