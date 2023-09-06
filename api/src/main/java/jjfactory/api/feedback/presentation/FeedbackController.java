package jjfactory.api.feedback.presentation;

import jjfactory.api.feedback.application.FeedbackFacade;
import jjfactory.api.feedback.presentation.dto.FeedbackDto;
import jjfactory.api.feedback.presentation.dto.FeedbackDtoMapper;
import jjfactory.common.feedback.domain.FeedbackCommand;
import jjfactory.common.feedback.domain.FeedbackInfo;
import jjfactory.common.global.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/feedbacks")
@RequiredArgsConstructor
@RestController
public class FeedbackController {
    private final FeedbackFacade feedbackFacade;
    private final FeedbackDtoMapper feedbackDtoMapper;

    @PostMapping("/{receiverUserId}")
    public CommonResponse createFeedback(@RequestBody FeedbackDto.CreateRequest request, @PathVariable Long receiverUserId){
        //todo
        Long loginUserId = 21L;

        FeedbackCommand.Create command = feedbackDtoMapper.of(request);
        return new CommonResponse(feedbackFacade.createFeedback(command, receiverUserId, loginUserId));
    }

    @GetMapping
    public CommonResponse<List<FeedbackDto.ListResponse>> getList(){
        //todo
        Long loginUserId = 21L;

        List<FeedbackDto.ListResponse> result = feedbackFacade.getList(loginUserId).stream()
                .map(feedbackDtoMapper::of)
                .collect(Collectors.toList());

        return new CommonResponse<>(result);
    }

    @PutMapping("/{feedbackId}")
    public CommonResponse update(@PathVariable Long feedbackId, @RequestBody FeedbackCommand.Update command){
        feedbackFacade.update(feedbackId, command);
        return CommonResponse.ok();
    }

    @DeleteMapping("/{feedbackId}")
    public CommonResponse delete(@PathVariable Long feedbackId){
        feedbackFacade.delete(feedbackId);
        return CommonResponse.ok();
    }

    @PostMapping("/{feedbackId}/like")
    public CommonResponse likeFeedback(@PathVariable Long feedbackId){
        //todo
        Long loginUserId = 21L;
        feedbackFacade.likeFeedback(feedbackId, loginUserId);

        return CommonResponse.ok();
    }

}
