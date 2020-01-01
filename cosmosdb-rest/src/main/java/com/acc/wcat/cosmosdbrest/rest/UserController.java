package com.acc.wcat.cosmosdbrest.rest;


import com.acc.wcat.cosmosdbrest.domain.User;
import com.acc.wcat.cosmosdbrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") final String id) {
        final Mono<User> saveUserMono = userRepository.findById(id);
        ResponseEntity<User> userResponseEntity;
        if(saveUserMono.hasElement().block()){
            User user = saveUserMono.block();
            userResponseEntity = new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
        }else{
            userResponseEntity =  ResponseEntity.notFound().build();
        }
        return userResponseEntity;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody final User user) {
        final Mono<User> saveUserMono = userRepository.save(user);
        return new ResponseEntity<User>(saveUserMono.block(), new HttpHeaders(), HttpStatus.CREATED);
    }
}
