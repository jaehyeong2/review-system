package jjfactory.common.review.domain;

import jjfactory.common.review.infra.ReviewAnswerSheetRepository;
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
