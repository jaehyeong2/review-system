package jjfactory.common.review.domain.peer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jjfactory.common.organization.domain.team.Team;
import jjfactory.common.period.domain.review_meta.PeerReviewMeta;
import jjfactory.common.period.domain.review_meta.TotalReviewMeta;
import jjfactory.common.period.domain.year_quarter.YearQuarter;
import jjfactory.common.review.infra.peer.PeerReviewerRepository;
import jjfactory.common.user.domain.User;
import jjfactory.common.user.domain.team.UserTeamHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class PeerReviewerServiceImplTest {
    @Autowired
    PeerReviewerService peerReviewerService;
    @PersistenceContext
    EntityManager em;
    @Autowired
    private PeerReviewerRepository peerReviewerRepository;

    YearQuarter yearQuarter;
    TotalReviewMeta totalReviewMeta;
    PeerReviewMeta peerReviewMeta;
    Team team;
    User userA;
    User userB;
    User userC;
    UserTeamHistory userTeamHistoryA;
    UserTeamHistory userTeamHistoryB;
    UserTeamHistory userTeamHistoryC;

    @BeforeEach
    void setUp() {
        yearQuarter = YearQuarter.builder().build();
        em.persist(yearQuarter);

        totalReviewMeta = TotalReviewMeta.builder()
                .yearQuarterId(yearQuarter.getId())
                .build();
        em.persist(totalReviewMeta);

        peerReviewMeta = PeerReviewMeta.builder()
                .totalReviewMeta(totalReviewMeta)
                .build();
        em.persist(peerReviewMeta);

        team = Team.builder()
                .name("team")
                .yearQuarterId(yearQuarter.getId())
                .build();
        em.persist(team);

        userA = User.builder()
                .name("userA")
                .build();

        userB = User.builder()
                .name("userB")
                .build();

        userC = User.builder()
                .name("userC")
                .build();

        em.persist(userA);
        em.persist(userB);
        em.persist(userC);

        userTeamHistoryA = UserTeamHistory.builder()
                .teamId(team.getId())
                .user(userA)
                .build();

        userTeamHistoryB = UserTeamHistory.builder()
                .teamId(team.getId())
                .user(userB)
                .build();

        userTeamHistoryC = UserTeamHistory.builder()
                .teamId(team.getId())
                .user(userC)
                .build();

        em.persist(userTeamHistoryA);
        em.persist(userTeamHistoryB);
        em.persist(userTeamHistoryC);

    }

    @Test
    @DisplayName("팀멤버 동료리뷰어로 추가")
    void addTeamMembersToPeerReviewer() {
        //given

        //when
        peerReviewerService.addTeamMembersToPeerReviewer(userA.getId(), peerReviewMeta.getId());

        //then
        List<PeerReviewer> list = peerReviewerRepository.findAll();

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.stream().map(PeerReviewer::getEvaluatorId).toList())
                .isEqualTo(List.of(userB.getId(), userC.getId()));

    }

    @Test
    @DisplayName("동료 리뷰어 조회")
    void findListByReceiveUserIdAndMetaId() {
        //given
        PeerReviewer peerReviewer = PeerReviewer.builder()
                .userId(userA.getId())
                .evaluatorId(userB.getId())
                .metaId(peerReviewMeta.getId())
                .build();

        PeerReviewer peerReviewer2 = PeerReviewer.builder()
                .userId(userA.getId())
                .evaluatorId(userC.getId())
                .metaId(peerReviewMeta.getId())
                .build();

        em.persist(peerReviewer);
        em.persist(peerReviewer2);

        //when
        List<PeerReviewerInfo.ListResponse> result = peerReviewerService.findListByReceiveUserIdAndMetaId(userA.getId(), peerReviewMeta.getId());

        //then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("동료 리뷰어 삭제")
    void delete() {
        //given
        PeerReviewer peerReviewer = PeerReviewer.builder()
                .userId(userA.getId())
                .evaluatorId(userB.getId())
                .metaId(peerReviewMeta.getId())
                .build();

        PeerReviewer peerReviewer2 = PeerReviewer.builder()
                .userId(userA.getId())
                .evaluatorId(userC.getId())
                .metaId(peerReviewMeta.getId())
                .build();

        em.persist(peerReviewer);
        em.persist(peerReviewer2);

        //when
        peerReviewerService.delete(peerReviewer.getId());

        //then
        assertThat(peerReviewerRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("동료 리뷰어 확정")
    void confirmPeerReviewer() {
        //given
        PeerReviewer peerReviewer = PeerReviewer.builder()
                .userId(userA.getId())
                .evaluatorId(userB.getId())
                .metaId(peerReviewMeta.getId())
                .build();

        PeerReviewer peerReviewer2 = PeerReviewer.builder()
                .userId(userA.getId())
                .evaluatorId(userC.getId())
                .metaId(peerReviewMeta.getId())
                .build();

        em.persist(peerReviewer);
        em.persist(peerReviewer2);

        //when
        peerReviewerService.confirmPeerReviewer(userA.getId(), Set.of(peerReviewer.getId(), peerReviewer2.getId()), peerReviewMeta.getId());
        List<PeerReviewer> list = peerReviewerRepository.findAll();

        //then
        assertThat(list.stream().map(PeerReviewer::isSubmitted).collect(Collectors.toSet())).isEqualTo(Set.of(true));
    }
}