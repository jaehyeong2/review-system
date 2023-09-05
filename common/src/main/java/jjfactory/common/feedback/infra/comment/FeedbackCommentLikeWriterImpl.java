package jjfactory.common.feedback.infra.comment;

import jjfactory.common.feedback.domain.comment.like.FeedbackCommentLike;
import jjfactory.common.feedback.domain.comment.like.FeedbackCommentLikeWriter;
import jjfactory.common.feedback.domain.like.FeedbackLike;
import jjfactory.common.feedback.infra.comment.like.FeedbackCommentLikeRepository;
import jjfactory.common.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedbackCommentLikeWriterImpl implements FeedbackCommentLikeWriter {
    private final FeedbackCommentLikeRepository feedbackCommentLikeRepository;
    @Override
    public FeedbackCommentLike write(FeedbackCommentLike feedbackCommentLike) {
        return feedbackCommentLikeRepository.save(feedbackCommentLike);
    }

    @Override
    public Long deleteById(Long id) {
        FeedbackCommentLike feedbackCommentLike = feedbackCommentLikeRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("feedback comment like not found");
        });

        feedbackCommentLikeRepository.delete(feedbackCommentLike);
        return id;
    }

    @Override
    public Long deleteByIdOrThrow(Long id) {
        FeedbackCommentLike feedbackCommentLike = feedbackCommentLikeRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("feedback comment like not found");
        });

        feedbackCommentLikeRepository.delete(feedbackCommentLike);
        return id;
    }
}
