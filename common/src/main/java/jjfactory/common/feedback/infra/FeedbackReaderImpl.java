package jjfactory.common.feedback.infra;

import jjfactory.common.feedback.domain.Feedback;
import jjfactory.common.feedback.domain.FeedbackReader;
import jjfactory.common.feedback.domain.comment.FeedbackComment;
import jjfactory.common.feedback.infra.comment.FeedbackCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class FeedbackReaderImpl implements FeedbackReader {
    private final FeedbackRepository feedbackRepository;
    private final FeedbackCommentRepository feedbackCommentRepository;

    @Override
    public Feedback get(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    @Override
    public FeedbackComment getComment(Long id) {
        return feedbackCommentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Feedback> getFeedbacksByReceiverId(Long receiverId) {
        return feedbackRepository.findAllByReceiveUserId(receiverId);
    }

    @Override
    public List<FeedbackComment> getComments(Long feedbackId) {
        return feedbackCommentRepository.findAllByFeedbackId(feedbackId);
    }
}
