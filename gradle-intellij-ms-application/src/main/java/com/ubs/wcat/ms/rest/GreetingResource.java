package com.ubs.wcat.ms.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/hello-world")
public interface GreetingResource {
    @GetMapping
    ResponseEntity<String> helloGreeting();
}
