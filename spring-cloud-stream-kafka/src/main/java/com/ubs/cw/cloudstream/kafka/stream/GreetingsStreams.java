package com.ubs.cw.cloudstream.kafka.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * The Interface GreetingsStreams. Define the Kafka Streams In order for our
 * application to be able to communicate with Kafka, we'll need to define an
 * outbound stream to write messages to a Kafka topic, and an inbound stream to
 * read messages from a Kafka topic.
 *
 * Spring Cloud provides a convenient way to do this by simply creating an
 * interface that defines a separate method for each stream. The
 * inboundGreetings() method defines the inbound stream to read from Kafka and
 * outboundGreetings() method defines the outbound stream to write to Kafka.
 */
public interface GreetingsStreams {
	String INPUT = "greetings-in";
	String OUTPUT = "greetings-out";

	@Input(INPUT)
	SubscribableChannel inboundGreetings();

	@Output(OUTPUT)
	MessageChannel outboundGreetings();
}
