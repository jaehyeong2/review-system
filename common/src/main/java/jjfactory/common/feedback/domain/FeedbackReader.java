package jjfactory.common.feedback.domain;

import jjfactory.common.feedback.domain.comment.FeedbackComment;

import java.util.List;

public interface FeedbackReader {
    Feedback get(Long id);

    FeedbackComment getComment(Long id);

    List<Feedback> getFeedbacksByReceiverId(Long receiverId);

}
