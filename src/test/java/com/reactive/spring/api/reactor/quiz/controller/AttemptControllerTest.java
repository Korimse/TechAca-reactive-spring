package com.reactive.spring.api.reactor.quiz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reactive.spring.api.reactor.quiz.domain.Attempt;
import com.reactive.spring.api.reactor.quiz.domain.Quiz;
import com.reactive.spring.api.reactor.quiz.domain.User;
import com.reactive.spring.api.reactor.quiz.service.QuizService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@WebMvcTest(AttemptController.class)
class AttemptControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean // Mock - 알고리즘 자체를 테스트, MockBean - 의존성 주입된 상태의 Service를 사용하기 때문에
    QuizService quizService;

    private JacksonTester<Attempt> jsonResult;
    private JacksonTester<AttemptController.ResultResponse> jsonResponse;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    void postResult() throws Exception{
//        genericParameterizedTest(true);
    }

    private void genericParameterizedTest(final boolean correct) throws Exception{
        given(quizService.checkAttempt(any(Attempt.class))).willReturn(correct);
        User user = new User("John", "happy-John");
        Quiz quiz = new Quiz(50, 70);
        Attempt attempt = new Attempt(user, quiz, 3500, correct);
        assertThat(attempt.getUser().getAlias(), is(equalTo("happy-john")));
//        MockHttpServletResponse response = mvc.perform(post("/results")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonResult.write(attempt).getJson())).andReturn().getResponse();
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString())
//                .isEqualTo(jsonResult.write(new Attempt(attempt.getUser(),
//                                attempt.getQuiz(),
//                                attempt.getResultAttempt(),
//                                correct))
//                        .getJson());
    }

    @Test
    void getStatistics() throws Exception{
    }

    @Test
    void getResultById() throws Exception{
    }
}