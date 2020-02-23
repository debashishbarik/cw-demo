package com.debashish.springdrools.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.debashish.springdrools.model.Order;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OfferController {

	private final KieSession session;

	@PostMapping("/order")
	public Order orderNow(@RequestBody final Order order) {
		session.insert(order);
		session.fireAllRules();
		return order;
	}
}
