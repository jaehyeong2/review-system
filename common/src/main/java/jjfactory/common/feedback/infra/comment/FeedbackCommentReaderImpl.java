package jjfactory.common.feedback.infra.comment;

import jjfactory.common.feedback.domain.comment.FeedbackComment;
import jjfactory.common.feedback.domain.comment.FeedbackCommentReader;
import jjfactory.common.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class FeedbackCommentReaderImpl implements FeedbackCommentReader {
    private final FeedbackCommentRepository feedbackCommentRepository;

    @Override
    public FeedbackComment get(Long id) {
        return feedbackCommentRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("comment not found");
        });
    }

    @Override
    public List<FeedbackComment> getComments(Long feedbackId) {
        return feedbackCommentRepository.findAllByFeedbackId(feedbackId);
    }
}
