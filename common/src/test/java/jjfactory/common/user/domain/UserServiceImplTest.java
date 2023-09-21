package jjfactory.common.user.domain;

import jjfactory.common.user.infra.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepository userRepository;

    @Test
    void getPage(){
        //given
        for(int i = 1; i < 31; i++){
            User user = User.builder().name("user" + i).build();
            userRepository.save(user);
        }

        Pageable request = PageRequest.of(0, 3);

        //when
        Page<UserInfo.ListResponse> result = userService.getAllUsers(request);

        //then
        assertThat(result.getTotalElements()).isEqualTo(30);
        assertThat(result.getTotalPages()).isEqualTo(10);
    }

    @Test
    void create() {
        //given
        UserCommand.Create createCommand = UserCommand.Create
                .builder().name("lee")
                .employeeNumber("20221234")
                .build();
        //when
        Long result = userService.create(createCommand);

        //then
        assertThat(result).isNotNull();
    }

    @Test
    void delete() {
        //given
        User lee = User.builder()
                .name("lee")
                .build();

        User entity = userRepository.save(lee);

        //when
        Long id = userService.delete(entity.getId());

        //then
        assertThat(id).isEqualTo(entity.getId());
        assertThat(entity.isValid()).isFalse();
    }

    @Test
    void get() {
        //given
        User lee = User.builder()
                .name("lee")
                .build();

        Long id = userRepository.save(lee).getId();

        //when
        UserInfo.DetailResponse result = userService.get(id);

        //then
        assertThat(result.getName()).isEqualTo("lee");
    }

    @DisplayName("팀원 조회 성공. 본인을 포함해서 조회 된")
    @Test
    void getTeamUsers() {
        //given
        User lee = User.builder()
                .name("lee")
                .teamId(21L)
                .build();

        User kim = User.builder()
                .name("kim")
                .teamId(21L)
                .build();

        User entity = userRepository.save(lee);
        userRepository.save(kim);

        //when
        List<UserInfo.ListResponse> teamUsers = userService.getTeamUsers(entity.getId());

        //then
        assertThat(teamUsers.size()).isEqualTo(2);
    }

    @Test
    void update() {
        //given
        User lee = User.builder()
                .name("lee")
                .teamId(1L)
                .email("testet@com")
                .build();

        Long id = userRepository.save(lee).getId();

        UserCommand.Update command = UserCommand.Update
                .builder()
                .username("jjh")
                .teamId(22L)
                .email("changed@naver.com")
                .build();

        //when
        userService.update(command, id);

        //then
        assertThat(lee.getUsername()).isEqualTo("jjh");
        assertThat(lee.getTeamId()).isEqualTo(22L);
        assertThat(lee.getEmail()).isEqualTo("changed@naver.com");
    }
}