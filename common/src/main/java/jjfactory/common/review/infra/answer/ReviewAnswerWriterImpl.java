package jjfactory.common.review.infra.answer;

import jjfactory.common.review.domain.answer.ReviewAnswerSheet;
import jjfactory.common.review.domain.answer.ReviewAnswerWriter;
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
