package jjfactory.common.feedback.infra.comment.like;

import jjfactory.common.feedback.domain.comment.like.FeedbackCommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackCommentLikeRepository extends JpaRepository<FeedbackCommentLike, Long> {
}