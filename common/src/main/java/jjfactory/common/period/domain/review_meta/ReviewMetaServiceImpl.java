package jjfactory.common.period.domain.review_meta;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ReviewMetaServiceImpl implements ReviewMetaService {
    private final ReviewMetaReader reviewMetaReader;
    private final ReviewMetaFactory reviewMetaFactory;

    @Override
    public Long deleteTotalReviewMeta(Long id) {
        TotalReviewMeta totalReviewMeta = reviewMetaReader.get(id);
        totalReviewMeta.delete();

        return totalReviewMeta.getId();
    }

    @Override
    public Long modifyTotalReviewMeta(Long id, ReviewMetaCommand.Update command) {
        return null;
    }

    @Override
    public Long createTotalReviewMeta(ReviewMetaCommand.Create command) {
        return reviewMetaFactory.writeTotalReviewMeta(command);
    }

    @Override
    public List<ReviewMetaInfo.ListResponse> getList() {
        return null;
    }

    @Override
    public ReviewMetaInfo.DetailResponse get(Long id) {
        return null;
    }

    @Override
    public ReviewMetaInfo.DetailResponse getLastMeta(Long id) {
        return null;
    }
}
