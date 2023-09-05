package jjfactory.common.feedback.infra.comment;

import jjfactory.common.feedback.domain.comment.FeedbackComment;
import jjfactory.common.feedback.domain.comment.FeedbackCommentWriter;
import jjfactory.common.feedback.infra.comment.FeedbackCommentRepository;
import jjfactory.common.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedbackCommentWriterImpl implements FeedbackCommentWriter {
    private final FeedbackCommentRepository feedbackCommentRepository;
    @Override
    public FeedbackComment write(FeedbackComment feedbackComment) {
        return feedbackCommentRepository.save(feedbackComment);
    }

    @Override
    public Long deleteByIdOrThrow(Long commentId) {
        FeedbackComment comment = feedbackCommentRepository.findById(commentId).orElseThrow(() -> {
            throw new ResourceNotFoundException("feedback comment not found");
        });

        feedbackCommentRepository.delete(comment);
        return commentId;
    }

    @Override
    public Long deleteById(Long commentId) {
        feedbackCommentRepository.deleteById(commentId);
        return commentId;
    }
}
