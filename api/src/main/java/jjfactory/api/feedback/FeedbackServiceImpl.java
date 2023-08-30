package jjfactory.api.feedback;

import jjfactory.common.feedback.infra.FeedbackRepository;
import jjfactory.common.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;
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
    public List<User> getList() {
        return null;
    }

    @Override
    public Long update() {
        return null;
    }
}
