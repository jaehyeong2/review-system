package jjfactory.common.feedback.infra;

import jjfactory.common.feedback.domain.Feedback;
import jjfactory.common.feedback.domain.FeedbackReader;
import jjfactory.common.feedback.infra.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedbackReaderImpl implements FeedbackReader {
    private final FeedbackRepository feedbackRepository;
    @Override
    public Feedback get(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }
}
