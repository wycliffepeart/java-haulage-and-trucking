package org.jht.server.controller;

import org.jht.server.entity.User;
import org.jht.server.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    ResponseEntity<?> login(@RequestBody User user){
        var optionalUser = this.userRepository.findByEmail(user.getEmail());

        if(optionalUser.isEmpty()){
            return new ResponseEntity<>("Error", null, HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok(optionalUser.get());
    }
}
