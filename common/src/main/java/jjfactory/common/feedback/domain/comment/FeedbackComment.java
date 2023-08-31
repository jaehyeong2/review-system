package jjfactory.common.feedback.domain.comment;

import jakarta.persistence.*;
import jjfactory.common.feedback.domain.Feedback;
import jjfactory.common.user.domain.User;

@Entity
public class FeedbackComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Feedback feedback;

    private String content;
}
