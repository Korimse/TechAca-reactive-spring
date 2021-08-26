package com.reactive.spring.api.reactor.quiz.service;


import com.reactive.spring.api.reactor.quiz.domain.Quiz;
import reactor.core.publisher.Mono;

public interface QuizService {
    Mono<Quiz> createQuiz();
}