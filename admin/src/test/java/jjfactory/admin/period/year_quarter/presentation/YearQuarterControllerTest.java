package jjfactory.admin.period.year_quarter.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import jjfactory.admin.period.year_quarter.application.YearQuarterFacade;
import jjfactory.admin.period.year_quarter.presentation.dto.YearQuarterDto;
import jjfactory.admin.period.year_quarter.presentation.dto.YearQuarterDtoMapperImpl;
import jjfactory.common.period.domain.year_quarter.YearQuarterInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(YearQuarterController.class)
class YearQuarterControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    YearQuarterFacade yearQuarterFacade;
    @SpyBean
    YearQuarterDtoMapperImpl yearQuarterDtoMapper;

    @Test
    void getAllYearQuarters() throws Exception {
        //given
        YearQuarterInfo.ListResponse res1 = YearQuarterInfo.ListResponse.builder()
                .year(2023)
                .quarter(1)
                .open(true)
                .build();

        YearQuarterInfo.ListResponse res2 = YearQuarterInfo.ListResponse.builder()
                .year(2023)
                .quarter(2)
                .build();

        //stub
        given(yearQuarterFacade.getAllYearQuarters())
                .willReturn(List.of(res1, res2));

        //expected
        mockMvc.perform(get("/year-quarters"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data[0].isOpen").value(true))
                .andExpect(jsonPath("$.data[0].year").value(2023))
                .andExpect(jsonPath("$.data[0].quarter").value(1))
                .andDo(print());
    }

    @Test
    void deleteByYear() throws Exception {
        //expected
        mockMvc.perform(delete("/year-quarters").param("year", "2023"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    void updateYearQuarters() throws Exception {
        //given
        YearQuarterDto.UpdateRequest request = YearQuarterDto.UpdateRequest.builder()
                .id(12L)
                .year(2023)
                .quarter(1)
                .build();

        String content = objectMapper.writeValueAsString(List.of(request));

        //stub
        given(yearQuarterFacade.updateYearQuarters(any()))
                .willReturn(List.of(12L));

        //expected
        mockMvc.perform(patch("/year-quarters")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data[0]").value(12L))
                .andDo(print());
    }

    @Test
    void openYearQuarters() throws Exception {
        //given
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.put("ids", List.of("2", "3"));

        //expected
        mockMvc.perform(patch("/year-quarters/open").params(map))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    void closeYearQuarters() throws Exception {
        //given
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.put("ids", List.of("2", "3"));

        //expected
        mockMvc.perform(patch("/year-quarters/close").params(map))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }
}