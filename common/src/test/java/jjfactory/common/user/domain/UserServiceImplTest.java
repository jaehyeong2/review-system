package jjfactory.common.user.domain;

import jjfactory.common.organization.domain.Organization;
import jjfactory.common.organization.domain.team.Team;
import jjfactory.common.organization.infra.OrganizationRepository;
import jjfactory.common.organization.infra.team.TeamRepository;
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
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Test
    @DisplayName("유저 페이징 조회 성공")
    void getPage() {
        //given
        Organization organization = Organization.builder()
                .build();

        organizationRepository.save(organization);

        Team team = Team.builder()
                .organization(organization)
                .name("team")
                .build();

        Team team2 = Team.builder()
                .organization(organization)
                .name("team2")
                .build();

        teamRepository.save(team);
        teamRepository.save(team2);


        for (int i = 1; i < 31; i++) {
            if(i % 2 == 0){
                User user = User.builder().name("user" + i)
                        .teamId(team.getId())
                        .build();
                userRepository.save(user);
            }else{
                User user = User.builder().name("user" + i)
                        .teamId(team2.getId())
                        .build();
                userRepository.save(user);
            }
        }

        Pageable request = PageRequest.of(0, 3);

        UserCondition condition = UserCondition.builder()
                .name("user")
                .teamName("team2")
                .build();

        //when
        Page<UserInfo.ListResponse> result = userService.getAllUsers(request, condition);

        //then
        assertThat(result.getTotalElements()).isEqualTo(15);
        assertThat(result.getTotalPages()).isEqualTo(5);
    }

    @Test
    @DisplayName("유저 생성 성공")
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
    @DisplayName("유저 삭제 시 invalid 된다.")
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
    @DisplayName("유저 상세조회 성공")
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
    @DisplayName("유저 업데이트 성공")
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