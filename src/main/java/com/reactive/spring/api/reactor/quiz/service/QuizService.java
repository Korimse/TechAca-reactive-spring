package com.reactive.spring.api.reactor.quiz.service;


import com.reactive.spring.api.reactor.quiz.domain.Attempt;
import com.reactive.spring.api.reactor.quiz.domain.Quiz;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QuizService {
    Mono<Quiz> createQuiz();

    boolean checkAttempt(Attempt attempt);

    Flux<Attempt> getStatsForUser(String alias);

    Mono<Attempt> getResultById(long id);
}