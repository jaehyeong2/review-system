package jjfactory.common.feedback.infra;

import jjfactory.common.feedback.domain.Feedback;
import jjfactory.common.feedback.domain.FeedbackWriter;
import jjfactory.common.feedback.domain.comment.FeedbackComment;
import jjfactory.common.feedback.infra.comment.FeedbackCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedbackWriterImpl implements FeedbackWriter {
    private final FeedbackRepository feedbackRepository;
    private final FeedbackCommentRepository feedbackCommentRepository;

    @Override
    public Feedback write(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public FeedbackComment writeComment(FeedbackComment feedbackComment) {
        return feedbackCommentRepository.save(feedbackComment);
    }

    @Override
    public Long deleteById(Long feedbackId) {
        Feedback feedback = feedbackRepository.findById(feedbackId).orElseThrow(() -> {
                    throw new IllegalCallerException();
                }
        );

        feedbackRepository.delete(feedback);

        return feedbackId;
    }
}
