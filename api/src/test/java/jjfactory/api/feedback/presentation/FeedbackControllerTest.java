package jjfactory.api.feedback.presentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jjfactory.api.feedback.application.FeedbackFacade;
import jjfactory.api.feedback.presentation.dto.FeedbackDto;
import jjfactory.api.feedback.presentation.dto.FeedbackDtoMapperImpl;
import jjfactory.common.feedback.domain.Feedback;
import jjfactory.common.feedback.domain.FeedbackCommand;
import jjfactory.common.feedback.domain.FeedbackInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(FeedbackController.class)
class FeedbackControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    FeedbackFacade feedbackFacade;

    @SpyBean
    FeedbackDtoMapperImpl feedbackDtoMapper;

    @Test
    @DisplayName("피드백 생성 성공")
    void createFeedback() throws Exception {
        //given
        FeedbackCommand.Create feedback = FeedbackCommand.Create.builder()
                .content("피드백이요~")
                .build();

        String content = objectMapper.writeValueAsString(feedback);

        //expected
        mockMvc.perform(post("/feedbacks")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    @DisplayName("피드백 리스트 조회 성공")
    void getList() throws Exception {
        //given
        FeedbackInfo.ListResponse res1 = FeedbackInfo.ListResponse.builder()
                .content("피드백1")
                .type(Feedback.Type.COMPLIMENT)
                .sendUserId(1L)
                .receiveUserId(2L)
                .build();

        FeedbackInfo.ListResponse res2 = FeedbackInfo.ListResponse.builder()
                .content("피드백2")
                .type(Feedback.Type.SUGGEST)
                .sendUserId(1L)
                .receiveUserId(3L)
                .build();

        //stub
        given(feedbackFacade.getList(21L))
                .willReturn(List.of(res1, res2));

        //expected
        mockMvc.perform(get("/feedbacks"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data[0].content").value("피드백1"))
                .andExpect(jsonPath("$.data[1].content").value("피드백2"))
                .andExpect(jsonPath("$.data[0].type").value(Feedback.Type.COMPLIMENT.toString()))
                .andExpect(jsonPath("$.data[1].type").value(Feedback.Type.SUGGEST.toString()))
                .andExpect(jsonPath("$.data[0].sendUserId").value(1L))
                .andExpect(jsonPath("$.data[1].receiveUserId").value(3L))
                .andDo(print());
    }

    @Test
    @DisplayName("피드백 수정 성공")
    void update() throws Exception {
        //given
        FeedbackDto.UpdateRequest updateRequest = FeedbackDto.UpdateRequest
                .builder()
                .build();

        String content = objectMapper.writeValueAsString(updateRequest);

        //expected
        mockMvc.perform(put("/feedbacks/1")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    @DisplayName("피드백 삭제 성공")
    void deleteById() throws Exception {
        //expected
        mockMvc.perform(delete("/feedbacks/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    @DisplayName("피드백 좋아요 성공")
    void likeFeedback() throws Exception {
        //expected
        mockMvc.perform(post("/feedbacks/1/like"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }
}