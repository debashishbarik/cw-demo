package com.ubs.cw.cloudstream.kafka.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class Greetings. class with below code that will represent the message
 * object we read from and write to the greetings Kafka topic:
 */
@Getter
@Setter
@ToString
@Builder
public class Greetings {

	private long timestamp;
	private String message;
}
