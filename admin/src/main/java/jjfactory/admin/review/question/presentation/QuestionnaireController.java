package jjfactory.admin.review.question.presentation;

import jjfactory.admin.review.question.application.QuestionnaireFacade;
import jjfactory.admin.review.question.presentation.dto.QuestionnaireDto;
import jjfactory.admin.review.question.presentation.dto.QuestionnaireDtoMapper;
import jjfactory.common.global.response.CommonResponse;
import jjfactory.common.review.domain.question.QuestionnaireCommand;
import jjfactory.common.review.domain.question.QuestionnaireInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/questionnaire")
@RequiredArgsConstructor
@RestController
public class QuestionnaireController {
    private final QuestionnaireFacade questionnaireFacade;
    private final QuestionnaireDtoMapper questionnaireDtoMapper;

    @PostMapping
    public CommonResponse<Long> createQuestionnaire(@RequestBody QuestionnaireCommand.Create command) {
        return new CommonResponse(questionnaireFacade.createQuestionnaire(command));
    }

    @DeleteMapping("/{id}")
    public CommonResponse delete(@PathVariable Long id) {
        questionnaireFacade.delete(id);
        return CommonResponse.ok();
    }

    @PutMapping("/{id}")
    public CommonResponse<Long> update(@PathVariable Long id, @RequestBody QuestionnaireCommand.Update command) {
        return new CommonResponse(questionnaireFacade.update(id, command));
    }

    @PatchMapping("/{id}/open")
    public CommonResponse openQuestionnaire(@PathVariable Long id) {
        questionnaireFacade.openQuestionnaire(id);
        return CommonResponse.ok();
    }

    @PostMapping("/{id}/clone")
    public CommonResponse clone(@PathVariable Long id, @RequestParam Long targetMetaId) {
        questionnaireFacade.clone(id, targetMetaId);
        return CommonResponse.ok();
    }

    @GetMapping
    public CommonResponse<List<QuestionnaireDto.ListResponse>> getQuestionnaires(@RequestParam Long metaId) {
        return new CommonResponse<>(questionnaireFacade.getQuestionnaires(metaId)
                .stream().map(questionnaireDtoMapper::of).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public CommonResponse<QuestionnaireDto.DetailResponse> getQuestionnaire(@PathVariable Long id) {
        return new CommonResponse(questionnaireDtoMapper.of(questionnaireFacade.getQuestionnaire(id)));
    }
}
