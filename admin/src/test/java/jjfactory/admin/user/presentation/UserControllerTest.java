package jjfactory.admin.user.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import jjfactory.admin.user.application.UserFacade;
import jjfactory.admin.user.presentation.dto.UserDtoMapperImpl;
import jjfactory.common.user.domain.UserCommand;
import jjfactory.common.user.domain.UserInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    UserFacade userFacade;
    @SpyBean
    UserDtoMapperImpl userDtoMapper;
    @Test
    @DisplayName("유저 상세 조회 성공")
    void getDetail() throws Exception {
        //expected
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    @DisplayName("유저 목록 조회 성공")
    void getPage() throws Exception {
        //given
        UserInfo.ListResponse user1 = UserInfo.ListResponse.builder()
                .name("user1")
                .teamId(17L)
                .employeeNumber("202211111")
                .email("abc@naver.com")
                .build();

        UserInfo.ListResponse user2 = UserInfo.ListResponse.builder()
                .name("user2")
                .teamId(18L)
                .employeeNumber("202222222")
                .email("abc2@naver.com")
                .build();

        List<UserInfo.ListResponse> list = List.of(user1, user2);

        PageRequest request = PageRequest.of(0, 1);
        PageImpl<UserInfo.ListResponse> result = new PageImpl<>(list, request, list.size());

        //stub
        when(userFacade.getPage(any(), any()))
                .thenReturn(result);

        //expected
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.totalPages").value(2))
                .andExpect(jsonPath("$.data.totalElements").value(2))
                .andDo(print());
    }

    @Test
    @DisplayName("유저 등록 성공")
    void enroll() throws Exception {
        //given
        UserCommand.Create command = UserCommand.Create.builder()
                .name("user2")
                .teamId(18L)
                .employeeNumber("202222222")
                .email("abc2@naver.com")
                .build();

        String content = objectMapper.writeValueAsString(command);

        //expected
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    @DisplayName("유저 수정성공")
    void modify() throws Exception {
        //given
        UserCommand.Update command = UserCommand.Update.builder()
                .teamId(18L)
                .email("abc2@naver.com")
                .username("wwjj")
                .build();

        String content = objectMapper.writeValueAsString(command);

        //expected
        mockMvc.perform(put("/users/1")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }
}