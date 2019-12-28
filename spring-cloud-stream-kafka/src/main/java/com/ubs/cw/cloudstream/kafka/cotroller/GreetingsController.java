package com.ubs.cw.cloudstream.kafka.cotroller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.cw.cloudstream.kafka.model.Greetings;
import com.ubs.cw.cloudstream.kafka.services.GreetingsService;

@RestController
public class GreetingsController {
	private final GreetingsService greetingsService;

	public GreetingsController(final GreetingsService greetingsService) {
		super();
		this.greetingsService = greetingsService;
	}

	@GetMapping("/greetings")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void greetings(@RequestParam("message") final String message) {
		final Greetings greetings = Greetings.builder().message(message).timestamp(System.currentTimeMillis()).build();
		greetingsService.sendGreeting(greetings);
	}
}
