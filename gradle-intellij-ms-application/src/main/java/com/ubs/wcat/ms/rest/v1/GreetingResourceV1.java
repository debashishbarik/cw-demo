package com.ubs.wcat.ms.rest.v1;


import com.ubs.wcat.ms.rest.GreetingResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingResourceV1 implements GreetingResource {
    @Override
    public ResponseEntity<String> helloGreeting()
    {
        return ResponseEntity.ok("Hello World!!!");
    }
}
