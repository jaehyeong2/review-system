package jjfactory.common.feedback.domain;

import jjfactory.common.feedback.domain.like.FeedbackLike;
import jjfactory.common.feedback.domain.like.FeedbackLikeWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackReader feedbackReader;
    private final FeedbackWriter feedbackWriter;
    private final FeedbackLikeWriter feedbackLikeWriter;
    private final FeedbackMapper feedbackMapper;

    @Transactional
    @Override
    public Long create(FeedbackCommand.Create command, Long sendUserId, Long receiverId) {
        //TODO security 기반

        Feedback feedback = feedbackWriter.write(command.toEntity(sendUserId, receiverId));
        return feedback.getId();
    }

    @Transactional
    @Override
    public Long delete(Long feedbackId) {
        return feedbackWriter.deleteById(feedbackId);
    }

    @Transactional(readOnly = true)
    @Override
    public FeedbackInfo.DetailResponse get(Long id) {
        return feedbackMapper.of(feedbackReader.get(id));
    }

    @Transactional(readOnly = true)
    @Override
    public List<FeedbackInfo.ListResponse> getList(Long loginUserId) {
        //TODO security 기반

        return feedbackReader.getFeedbacksByReceiverId(loginUserId)
                .stream().map(feedbackMapper::ofListResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Long update(Long feedbackId, FeedbackCommand.Update command) {
        Feedback feedback = feedbackReader.get(feedbackId);
        feedback.update(command.getContent(), command.getType());

        return feedback.getId();
    }

    @Transactional
    @Override
    public void like(Long feedbackId, Long userId){
        Feedback feedback = feedbackReader.get(feedbackId);

        FeedbackLike feedbackLike = FeedbackLike.create(feedback, userId);
        feedbackLikeWriter.write(feedbackLike);

        feedback.increaseLikeCount();
    }
}
