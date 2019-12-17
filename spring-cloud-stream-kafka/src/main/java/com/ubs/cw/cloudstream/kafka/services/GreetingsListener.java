package com.ubs.cw.cloudstream.kafka.services;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ubs.cw.cloudstream.kafka.model.Greetings;
import com.ubs.cw.cloudstream.kafka.stream.GreetingsStreams;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GreetingsListener {
	@StreamListener(GreetingsStreams.INPUT)
	public void handleGreetings(@Payload final Greetings greetings) {
		log.info("Received greetings: {}", greetings);
	}
}
