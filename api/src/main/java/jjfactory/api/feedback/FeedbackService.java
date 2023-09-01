package jjfactory.api.feedback;

import jjfactory.common.feedback.domain.Feedback;
import jjfactory.common.user.domain.User;

import java.util.List;

public interface FeedbackService {
    Long create();
    Long delete();
    User get(Long id);
    List<Feedback> getList();
    Long update();
}