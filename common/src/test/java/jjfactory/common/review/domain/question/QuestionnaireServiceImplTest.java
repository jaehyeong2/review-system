package jjfactory.common.review.domain.question;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jjfactory.common.review.domain.question.Questionnaire.Status;
import jjfactory.common.review.infra.question.CategoryRepository;
import jjfactory.common.review.infra.question.QuestionRepository;
import jjfactory.common.review.infra.question.QuestionnaireRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class QuestionnaireServiceImplTest {
    @Autowired
    QuestionnaireServiceImpl questionnaireService;
    @Autowired
    QuestionnaireRepository questionnaireRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    QuestionRepository questionRepository;
    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("짊문지 삭제 성공")
    void delete() {
        //given
        Questionnaire questionnaire = Questionnaire.builder().build();
        questionnaireRepository.save(questionnaire);

        Category category = Category.builder()
                .questionnaire(questionnaire)
                .build();
        categoryRepository.save(category);


        Question question = Question.builder()
                .category(category)
                .build();
        questionRepository.save(question);

        //when
        em.clear();
        questionnaireService.delete(questionnaire.getId());

        List<Questionnaire> all = questionnaireRepository.findAll();
        List<Category> categories = categoryRepository.findAll();
        List<Question> questions = questionRepository.findAll();

        //then
        assertThat(all.size()).isEqualTo(0);
        assertThat(categories.size()).isEqualTo(0);
        assertThat(questions.size()).isEqualTo(0);

    }

    @Test
    @DisplayName("짊문지 수정 성공")
    void update() {
        //given
        Questionnaire questionnaire = Questionnaire.builder()
                .metaId(17L)
                .title("질문지1")
                .build();
        questionnaireRepository.save(questionnaire);

        Category category = Category.builder()
                .questionnaire(questionnaire)
                .build();
        categoryRepository.save(category);


        Question question = Question.builder()
                .category(category)
                .build();
        questionRepository.save(question);

        QuestionnaireCommand.UpdateQuestion question1 = QuestionnaireCommand.UpdateQuestion.builder()
                .content("질문1입니다.")
                .id(question.getId())
                .seq(1)
                .build();

        QuestionnaireCommand.UpdateQuestion question2 = QuestionnaireCommand.UpdateQuestion.builder()
                .content("질문1입니다.")
                .seq(2)
                .build();

        QuestionnaireCommand.UpdateCategory categoryCommand = QuestionnaireCommand.UpdateCategory.builder()
                .description("cate desc")
                .title("cate title")
                .seq(1)
                .questions(Set.of(question1, question2))
                .id(category.getId())
                .build();


        QuestionnaireCommand.Update updateCommand = QuestionnaireCommand.Update.builder()
                .description("desc")
                .title("title")
                .categories(Set.of(categoryCommand))
                .build();

        //when
        questionnaireService.update(questionnaire.getId(), updateCommand);
        em.flush();

        //then
        Questionnaire findQuestionnaire = questionnaireRepository.findAll().get(0);

        assertThat(findQuestionnaire.getDescription()).isEqualTo("desc");
        assertThat(findQuestionnaire.getTitle()).isEqualTo("title");
    }

    @Test
    @DisplayName("짊문지 공개 성공")
    void openQuestionnaire() {
        //given
        Questionnaire questionnaire = Questionnaire.builder().build();
        questionnaireRepository.save(questionnaire);

        //when
        questionnaireService.openQuestionnaire(questionnaire.getId());
        Questionnaire find = questionnaireRepository.findAll().get(0);

        //then
        assertThat(find.getStatus()).isEqualTo(Status.OPEN);
    }

    @Test
    @DisplayName("짊문지 복사 성공")
    void testClone() {
        //given
        Questionnaire questionnaire = Questionnaire.builder()
                .metaId(17L)
                .title("질문지1")
                .build();
        questionnaireRepository.save(questionnaire);

        Category category = Category.builder()
                .questionnaire(questionnaire)
                .build();
        categoryRepository.save(category);


        Question question = Question.builder()
                .category(category)
                .build();
        questionRepository.save(question);

        //when
        questionnaireService.clone(questionnaire.getId(), 18L);

        //then
        assertThat(questionnaireRepository.findAll().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("짊문지 리스트 조회 성공")
    void getQuestionnaires() {
        //given
        Questionnaire questionnaire = Questionnaire.builder()
                .metaId(17L)
                .title("질문지1")
                .build();
        questionnaireRepository.save(questionnaire);

        Questionnaire questionnaire2 = Questionnaire.builder()
                .title("질문지2")
                .metaId(18L)
                .build();
        questionnaireRepository.save(questionnaire2);

        Category category = Category.builder()
                .questionnaire(questionnaire)
                .build();
        categoryRepository.save(category);


        Question question = Question.builder()
                .category(category)
                .build();
        questionRepository.save(question);

        //when
        List<QuestionnaireInfo.ListResponse> responses = questionnaireService.getQuestionnaires(17L);

        //then
        assertThat(responses.size()).isEqualTo(1);
        assertThat(responses.get(0).getTitle()).isEqualTo("질문지1");
    }

    @Test
    @DisplayName("짊문지 단건 조회 성공")
    void getQuestionnaire() {
        //given
        Questionnaire questionnaire = Questionnaire.builder()
                .metaId(17L)
                .title("질문지1")
                .build();
        questionnaireRepository.save(questionnaire);

        Questionnaire questionnaire2 = Questionnaire.builder()
                .title("질문지2")
                .metaId(18L)
                .build();
        questionnaireRepository.save(questionnaire2);

        Category category = Category.builder()
                .questionnaire(questionnaire)
                .build();
        categoryRepository.save(category);


        Question question = Question.builder()
                .category(category)
                .build();
        questionRepository.save(question);

        //when
        QuestionnaireInfo.DetailResponse result = questionnaireService.getQuestionnaire(questionnaire.getId());

        //then
        assertThat(result.getTitle()).isEqualTo("질문지1");
    }
}