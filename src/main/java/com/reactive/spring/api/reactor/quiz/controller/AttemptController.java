package com.reactive.spring.api.reactor.quiz.controller;

import com.reactive.spring.api.reactor.quiz.domain.Attempt;
import com.reactive.spring.api.reactor.quiz.service.QuizService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/results")
public class AttemptController {
    private final QuizService quizService;

    @RequiredArgsConstructor
    @NoArgsConstructor(force = true)
    @Getter
    static final class ResultResponse{
        private final boolean correct;
    }
    @PostMapping
    ResponseEntity<Attempt> postResult(@RequestBody Attempt attempt) {
        boolean isCorrect = quizService.checkAttempt(attempt);
        Attempt attemptCopy = new Attempt(attempt.getUser(), attempt.getQuiz(), attempt.getResultAttempt(), isCorrect);
        return ResponseEntity.ok(attemptCopy);
    }

    @GetMapping
    ResponseEntity<Flux<Attempt>> getStatistics(@RequestParam("alias") String alias) {
        return ResponseEntity.ok(quizService.getStatsForUser(alias));
    }

    @GetMapping("/{id}")
    ResponseEntity<Mono<Attempt>> getResultById(final @PathVariable("id") long id) {
        return ResponseEntity.ok(quizService.getResultById(id));
    }
}
