package com.ubs.cw.kafka.rest.producer.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ubs.cw.kafka.rest.producer.mesages.LeaveMessages;

/**
 * The Class LeaveProducerService.
 *
 * @author debashish.barik
 */
@Service
public class LeaveProducerService {

	/** The leave producer. */
	private final KafkaTemplate<String, String> leaveProducer;

	private final KafkaTemplate<String, Object> leaveObjectProducer;

	public LeaveProducerService(final KafkaTemplate<String, String> leaveProducer,
			final KafkaTemplate<String, Object> leaveObjectProducer) {
		super();
		this.leaveProducer = leaveProducer;
		this.leaveObjectProducer = leaveObjectProducer;
	}

	/**
	 * Send.
	 *
	 * @param message the message
	 */
	public void send(final String message) {
		leaveProducer.send("leave-message-topic", message);
	}

	/**
	 * Send.
	 *
	 * @param message the message
	 */
	public void sendObject(final LeaveMessages leaveMessages) {
		leaveObjectProducer.send("leave-message-object-topic", leaveMessages);
	}
}
