package jjfactory.api.feedback.application;

import jjfactory.common.feedback.domain.comment.FeedbackCommentCommand;
import jjfactory.common.feedback.domain.comment.FeedbackCommentInfo;
import jjfactory.common.feedback.domain.comment.FeedbackCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedbackCommentFacade {
    private final FeedbackCommentService feedbackCommentService;

    public List<FeedbackCommentInfo.ListResponse> getComments(Long feedbackId){
        return feedbackCommentService.getList(feedbackId);
    }

    public void deleteComment(Long commentId, Long userId){
        feedbackCommentService.delete(commentId, userId);
    }

    public void createComment(FeedbackCommentCommand.Create command, Long feedbackId, Long userId){
        feedbackCommentService.create(command, feedbackId, userId);
    }

    public void updateComment(FeedbackCommentCommand.Update command, Long commentId, Long userId){
        feedbackCommentService.update(commentId,command, userId);
    }

    public void likeComment(Long commentId, Long userId){
        feedbackCommentService.like(commentId, userId);
    }
}
