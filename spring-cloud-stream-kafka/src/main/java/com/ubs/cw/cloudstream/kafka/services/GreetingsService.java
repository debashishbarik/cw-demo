package com.ubs.cw.cloudstream.kafka.services;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.ubs.cw.cloudstream.kafka.model.Greetings;
import com.ubs.cw.cloudstream.kafka.stream.GreetingsStreams;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GreetingsService {
	private final GreetingsStreams greetingsStreams;

	public GreetingsService(final GreetingsStreams greetingsStreams) {
		super();
		this.greetingsStreams = greetingsStreams;
	}

	public void sendGreeting(final Greetings greetings) {
		log.info("Sending greetings {}", greetings);
		final MessageChannel messageChannel = greetingsStreams.outboundGreetings();
		messageChannel.send(MessageBuilder.withPayload(greetings)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
	}
}
