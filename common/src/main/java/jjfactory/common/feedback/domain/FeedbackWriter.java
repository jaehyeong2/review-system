package jjfactory.common.feedback.domain;


public interface FeedbackWriter {
    Feedback write(Feedback feedback);
    Long deleteById(Long feedbackId);
}
