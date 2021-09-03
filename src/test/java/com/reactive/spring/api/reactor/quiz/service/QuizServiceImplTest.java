package com.reactive.spring.api.reactor.quiz.service;

import com.reactive.spring.api.reactor.quiz.domain.Quiz;
import com.reactive.spring.api.reactor.quiz.repository.AttemptRepository;
import com.reactive.spring.api.reactor.quiz.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
@ExtendWith(MockitoExtension.class)
class QuizServiceImplTest {
    private QuizServiceImpl quizService;
    @Mock
    GeneratorServiceImpl generatorService;
    @Mock
    UserRepository userRepository;
    @Mock
    AttemptRepository attemptRepository;

    @BeforeEach
    void setUp() {
        quizService = new QuizServiceImpl(generatorService, userRepository, attemptRepository);
    }

    @DisplayName("50 * 30 = 1500")
    @Test
    void createQuiz() {
        given(generatorService.randomFactor()).willReturn(50, 30);
        Mono<Quiz> quiz = quizService.createQuiz();
        Quiz q = quiz.block();
        assertThat(q.getFactorA(), is(50));
        assertThat(q.getFactorB(), is(30));
        assertThat(q.getResult(), is(1500));
    }
}