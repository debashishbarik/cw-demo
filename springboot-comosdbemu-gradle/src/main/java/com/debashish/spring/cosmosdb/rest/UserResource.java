package com.debashish.spring.cosmosdb.rest;

import com.debashish.spring.cosmosdb.rest.v1.request.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserResource {

    @GetMapping
    ResponseEntity<List<User>> findAllUser();

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user);

    @GetMapping("/{id}")
    ResponseEntity<User> findUserById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id);
}
