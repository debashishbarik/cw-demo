package com.ubs.cw.kafka.rest.producer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.cw.kafka.rest.producer.mesages.LeaveMessages;
import com.ubs.cw.kafka.rest.producer.services.LeaveProducerService;

/**
 * The Class LeaveProducerController.
 *
 * @author debashish.barik
 */
@RestController
@RequestMapping("/leaveproducer")
public class LeaveProducerController {

	/** The leave producer service. */
	LeaveProducerService leaveProducerService;

	/**
	 * Instantiates a new leave producer controller.
	 *
	 * @param leaveProducerService the leave producer service
	 */
	public LeaveProducerController(final LeaveProducerService leaveProducerService) {
		this.leaveProducerService = leaveProducerService;
	}

	/**
	 * Message.
	 *
	 * @param message the message
	 * @return the response entity
	 */
	@PostMapping("/message")
	public ResponseEntity<String> message(@RequestBody final String message) {
		System.out.println("Message::" + message);
		leaveProducerService.send(message);
		return ResponseEntity.ok("Message received: " + message);
	}

	/**
	 * Message Object.[TODO Inprogress]
	 *
	 * @param message the message
	 * @return the response entity
	 */
	@PostMapping("/messageobject")
	public ResponseEntity<String> messageObject(@RequestBody final LeaveMessages leaveMessages) {
		System.out.println("MessageObj::" + leaveMessages);
		leaveProducerService.sendObject(leaveMessages);
		return ResponseEntity.ok("Message received: " + leaveMessages);
	}
}
