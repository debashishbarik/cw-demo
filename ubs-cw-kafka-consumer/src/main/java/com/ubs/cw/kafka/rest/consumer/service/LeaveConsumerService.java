package com.ubs.cw.kafka.rest.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ubs.cw.kafka.rest.consumer.messages.LeaveMessages;

/**
 * The Class LeaveConsumerService.
 *
 * @author debashish.barik
 */
@Service
public class LeaveConsumerService {

	/**
	 * Consume message.
	 *
	 * @param message the message
	 */
	@KafkaListener(id = "leave-consumer", topics = "leave-message-topic")
	public void consumeMessage(final String message) {
		System.out.println("Got message: " + message);
	}

	/**
	 * Consume message.
	 *
	 * @param message the message
	 */
	@KafkaListener(id = "leave-consumer-object", topics = "leave-message-object-topic")
	public void consumeObjectMessage(final LeaveMessages message) {
		System.out.println("Got Object message: " + message);
	}
}
