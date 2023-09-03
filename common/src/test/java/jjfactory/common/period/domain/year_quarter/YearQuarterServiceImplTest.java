package jjfactory.common.period.domain.year_quarter;

import jjfactory.common.period.infra.year_quarter.YearQuarterRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class YearQuarterServiceImplTest {
    @Autowired YearQuarterService yearQuarterService;
    @Autowired
    YearQuarterRepository yearQuarterRepository;

    @BeforeEach
    void setUp(){
        yearQuarterRepository.deleteAll();
    }

    @Test
    @DisplayName("년도 desc 분기 desc로 정렬되서 조회된다")
    void getAllYearQuarters() {
        //given
        YearQuarter yq1 = YearQuarter.builder()
                .year(2023)
                .quarter(1)
                .build();

        YearQuarter yq2 = YearQuarter.builder()
                .year(2023)
                .quarter(2)
                .build();

        YearQuarter yq3 = YearQuarter.builder()
                .year(2022)
                .quarter(4)
                .build();

        yearQuarterRepository.save(yq1);
        yearQuarterRepository.save(yq2);
        yearQuarterRepository.save(yq3);

        //when
        List<YearQuarterInfo.ListResponse> result = yearQuarterService.getAllYearQuarters();

        //then
        assertThat(result.get(0).getYear()).isEqualTo(result.get(1).getYear());
        assertThat(result.get(1).getYear()).isGreaterThan(result.get(2).getYear());
    }

    @Test
    @DisplayName("대상년도 분기만 삭제된다")
    void deleteByYear() {
        //given
        YearQuarter yq1 = YearQuarter.builder()
                .year(2023)
                .quarter(1)
                .build();

        YearQuarter yq2 = YearQuarter.builder()
                .year(2023)
                .quarter(2)
                .build();

        YearQuarter yq3 = YearQuarter.builder()
                .year(2022)
                .quarter(4)
                .build();

        yearQuarterRepository.save(yq1);
        yearQuarterRepository.save(yq2);
        yearQuarterRepository.save(yq3);

        //when
        yearQuarterService.deleteByYear(2023);

        //then
        assertThat(yearQuarterRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("분기 정보 수정 성공")
    void updateYearQuarters() {
        //given
        YearQuarter yq1 = YearQuarter.builder()
                .year(2023)
                .quarter(1)
                .build();

        YearQuarter saveEntity = yearQuarterRepository.save(yq1);

        LocalDateTime dummyDateTime = LocalDateTime.of(2022, 9, 1, 0, 0, 0);

        YearQuarterCommand.Update command = YearQuarterCommand.Update.builder()
                .id(saveEntity.getId())
                .year(2022)
                .quarter(3)
                .startDt(dummyDateTime)
                .endDt(dummyDateTime.plusDays(1))
                .build();

        //when
        yearQuarterService.updateYearQuarters(List.of(command));
        YearQuarter yearQuarter = yearQuarterRepository.findAll().get(0);


        //then
        assertThat(yearQuarter.getYear()).isEqualTo(2022);
        assertThat(yearQuarter.getQuarter()).isEqualTo(3);
        assertThat(yearQuarter.getStartDt()).isEqualTo(dummyDateTime);
        assertThat(yearQuarter.getEndDt()).isEqualTo(dummyDateTime.plusDays(1));
    }

    @Test
    @DisplayName("분기 활성화 성공")
    void open(){
        //given
        YearQuarter yq1 = YearQuarter.builder()
                .year(2023)
                .quarter(1)
                .build();

        YearQuarter yq2 = YearQuarter.builder()
                .year(2023)
                .quarter(2)
                .build();

        YearQuarter save = yearQuarterRepository.save(yq1);
        YearQuarter save2 = yearQuarterRepository.save(yq2);

        //when
        yearQuarterService.openYearQuarters(List.of(save.getId(), save2.getId()));

        //then
        assertThat(yearQuarterRepository.findAll().stream()
                .map(YearQuarter::isOpen)
                .collect(Collectors.toSet()))
                .isEqualTo(Set.of(true));
    }

    @Test
    @DisplayName("분기 비활성화 성공")
    void close(){
        //given
        YearQuarter yq1 = YearQuarter.builder()
                .year(2023)
                .quarter(1)
                .isOpen(true)
                .build();

        YearQuarter yq2 = YearQuarter.builder()
                .year(2023)
                .quarter(2)
                .isOpen(true)
                .build();

        YearQuarter save = yearQuarterRepository.save(yq1);
        YearQuarter save2 = yearQuarterRepository.save(yq2);

        //when
        yearQuarterService.closeYearQuarters(List.of(save.getId(), save2.getId()));

        //then
        assertThat(yearQuarterRepository.findAll().stream()
                .map(YearQuarter::isOpen)
                .collect(Collectors.toSet()))
                .isEqualTo(Set.of(false));
    }
}