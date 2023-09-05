package jjfactory.common.feedback.infra.like;

import jjfactory.common.feedback.domain.like.FeedbackLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackLikeRepository extends JpaRepository<FeedbackLike, Long> {
}