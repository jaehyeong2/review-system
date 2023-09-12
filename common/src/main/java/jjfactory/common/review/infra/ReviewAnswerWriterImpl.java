package jjfactory.common.review.infra;

import jjfactory.common.review.domain.ReviewAnswerSheet;
import jjfactory.common.review.domain.ReviewAnswerWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReviewAnswerWriterImpl implements ReviewAnswerWriter {
    private final ReviewAnswerSheetRepository reviewAnswerSheetRepository;

    @Override
    public ReviewAnswerSheet writeAnswerSheet(ReviewAnswerSheet reviewAnswerSheet) {
        return reviewAnswerSheetRepository.save(reviewAnswerSheet);
    }
}
