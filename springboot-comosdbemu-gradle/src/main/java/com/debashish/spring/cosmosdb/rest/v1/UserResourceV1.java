package com.debashish.spring.cosmosdb.rest.v1;

import com.debashish.spring.cosmosdb.rest.UserResource;
import com.debashish.spring.cosmosdb.rest.v1.request.User;
import com.debashish.spring.cosmosdb.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1")
public class UserResourceV1 implements UserResource {

    UserService userService;

    public UserResourceV1(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<List<User>> findAllUser() {
        return ResponseEntity.ok(userService.findAllUser());
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.newUser(user));
    }

    @Override
    public ResponseEntity<User> findUserById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<User> updateUser(User user, Long id) {
        return null;
    }

    @Override
    public ResponseEntity deleteUser(Long id) {
        return null;
    }
}
