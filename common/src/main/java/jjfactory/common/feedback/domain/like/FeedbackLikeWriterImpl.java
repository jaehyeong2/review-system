package jjfactory.common.feedback.domain.like;

import jjfactory.common.feedback.infra.like.FeedbackLikeRepository;
import jjfactory.common.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedbackLikeWriterImpl implements FeedbackLikeWriter {
    private final FeedbackLikeRepository feedbackLikeRepository;
    @Override
    public FeedbackLike write(FeedbackLike feedbackLike) {
        return feedbackLikeRepository.save(feedbackLike);
    }

    @Override
    public Long delete(Long id) {
        FeedbackLike feedbackLike = feedbackLikeRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("feedback like not found");
        });

        feedbackLikeRepository.delete(feedbackLike);
        return id;
    }
}
