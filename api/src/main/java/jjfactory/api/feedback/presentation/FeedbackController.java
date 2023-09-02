package jjfactory.api.feedback.presentation;

import jjfactory.api.feedback.application.FeedbackFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/feedbacks")
@RequiredArgsConstructor
@RestController
public class FeedbackController {
    private final FeedbackFacade feedbackFacade;


}
