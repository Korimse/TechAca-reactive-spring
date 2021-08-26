package com.reactive.spring.api.reactor.quiz.repository;

import com.reactive.spring.api.reactor.quiz.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, Long> {
    Optional<User> findByAlias(String alias);
    Flux<User> findAll();
    Mono<User> findByUserid();
}
