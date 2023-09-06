package jjfactory.common.feedback.domain.comment;

import jjfactory.common.feedback.domain.Feedback;
import jjfactory.common.feedback.domain.FeedbackMapper;
import jjfactory.common.feedback.domain.FeedbackReader;
import jjfactory.common.feedback.domain.comment.like.FeedbackCommentLike;
import jjfactory.common.feedback.domain.comment.like.FeedbackCommentLikeWriter;
import jjfactory.common.global.exception.AccessForbiddenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class FeedbackCommentServiceImpl implements FeedbackCommentService {
    private final FeedbackCommentReader feedbackCommentReader;
    private final FeedbackCommentWriter feedbackCommentWriter;
    private final FeedbackReader feedbackReader;
    private final FeedbackCommentLikeWriter feedbackCommentLikeWriter;
    private final FeedbackMapper feedbackMapper;

    @Transactional(readOnly = true)
    @Override
    public List<FeedbackCommentInfo.ListResponse> getList(Long feedbackId) {
        return feedbackCommentReader.getComments(feedbackId).stream()
                .map(feedbackMapper::ofListResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Long delete(Long commentId, Long userId) {
        FeedbackComment feedbackComment = feedbackCommentReader.get(commentId);

        if (!feedbackComment.getUserId().equals(userId)) {
            throw new AccessForbiddenException();
        }

        return feedbackCommentWriter.deleteByIdOrThrow(commentId);
    }

    @Transactional
    @Override
    public Long create(FeedbackCommentCommand.Create command, Long feedbackId, Long userId) {
        Feedback feedback = feedbackReader.get(feedbackId);

        FeedbackComment feedbackComment = command.toEntity(feedback, userId);
        return feedbackCommentWriter.write(feedbackComment).getId();
    }

    @Transactional
    @Override
    public Long update(Long commentId, FeedbackCommentCommand.Update command, Long userId) {
        FeedbackComment feedbackComment = feedbackCommentReader.get(commentId);

        if (!feedbackComment.getUserId().equals(userId)) {
            throw new AccessForbiddenException();
        }

        feedbackComment.update(command.getContent());
        return commentId;
    }

    @Transactional
    @Override
    public void like(Long commentId, Long userId) {
        FeedbackComment feedbackComment = feedbackCommentReader.get(commentId);

        feedbackCommentLikeWriter.write(FeedbackCommentLike.create(feedbackComment, userId));
        feedbackComment.increaseLikeCount();
    }
}
