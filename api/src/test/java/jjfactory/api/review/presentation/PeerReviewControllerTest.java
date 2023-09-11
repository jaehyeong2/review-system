package jjfactory.api.review.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import jjfactory.api.review.presentation.peer.PeerReviewController;
import jjfactory.api.review.presentation.peer.dto.PeerReviewDtoMapperImpl;
import jjfactory.api.review.qpplication.peer.PeerReviewFacade;
import jjfactory.common.review.domain.peer.PeerReviewer;
import jjfactory.common.review.domain.peer.PeerReviewerInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PeerReviewController.class)
class PeerReviewControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    PeerReviewFacade peerReviewFacade;
    @SpyBean
    PeerReviewDtoMapperImpl peerReviewDtoMapper;

    @Test
    @DisplayName("본인 팀 동료 리뷰어 추가")
    void addTeamMembersToPeerReviewer() throws Exception {
        //expected
        mockMvc.perform(post("/reviews/peer/reviewr")
                        .param("metaId", "17")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    @DisplayName("동료 리뷰어 조회")
    void findListByReceiveUserIdAndMetaId() throws Exception {
        //given
        PeerReviewerInfo.ListResponse res1 = PeerReviewerInfo.ListResponse.builder()
                .userId(1L)
                .evaluatorId(2L)
                .metaId(17L)
                .type(PeerReviewer.CreationType.TEAM)
                .build();

        PeerReviewerInfo.ListResponse res2 = PeerReviewerInfo.ListResponse.builder()
                .userId(1L)
                .evaluatorId(3L)
                .metaId(17L)
                .type(PeerReviewer.CreationType.TEAM)
                .build();

        //stub
        given(peerReviewFacade.findListByReceiveUserIdAndMetaId(any(), any()))
                .willReturn(List.of(res1, res2));


        //expected
        mockMvc.perform(get("/reviews/peer/reviewr")
                        .param("metaId", "17")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data[0].evaluatorId").value(2))
                .andExpect(jsonPath("$.data[1].evaluatorId").value(3))
                .andDo(print());
    }

    @Test
    @DisplayName("동료 리뷰어 삭제")
    void deleteReviewerById() throws Exception {

        //expected
        mockMvc.perform(delete("/reviews/peer/reviewr/1"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}