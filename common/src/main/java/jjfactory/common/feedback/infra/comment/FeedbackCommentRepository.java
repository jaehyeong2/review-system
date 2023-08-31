package jjfactory.common.feedback.infra.comment;

import jjfactory.common.feedback.domain.comment.FeedbackComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackCommentRepository extends JpaRepository<FeedbackComment, Long> {
    List<FeedbackComment> findAllByFeedbackId(Long feedbackId);
}
