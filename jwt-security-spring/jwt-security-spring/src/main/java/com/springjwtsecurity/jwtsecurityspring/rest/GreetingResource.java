package com.springjwtsecurity.jwtsecurityspring.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("v1")
public interface GreetingResource {
    @GetMapping("/hello-world")
    ResponseEntity<String> helloGreeting();
}
