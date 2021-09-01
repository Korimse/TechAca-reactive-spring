package com.reactive.spring.api.reactor.quiz.controller;

import com.reactive.spring.api.reactor.quiz.domain.Producers;
import com.reactive.spring.api.reactor.quiz.service.KafkaSender;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class KafkaController {
    private final KafkaSender kafkaSender;
    private final Producers producers;

    @GetMapping
    public String hello() {
        return "Hello kafka";
    }

    @GetMapping("/producer")
    public String producer(@RequestParam("message") String message) {
        System.out.println("########## Producer 진입 ###########");
        kafkaSender.send(message);
        return "Message Sent to Kafka Successfully";
    }

    @GetMapping("/receiver")
    public void receiver() {
        producers.sendMessage("kafka-test", "Good-luck");
    }
}
