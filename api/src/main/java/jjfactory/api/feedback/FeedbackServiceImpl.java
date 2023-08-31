package jjfactory.api.feedback;

import jjfactory.common.feedback.domain.Feedback;
import jjfactory.common.feedback.domain.FeedbackReader;
import jjfactory.common.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackReader feedbackReader;
    @Override
    public Long create() {
        return null;
    }

    @Override
    public Long delete() {
        return null;
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public List<Feedback> getList() {
        return null;
    }

    @Override
    public Long update() {
        return null;
    }
}
