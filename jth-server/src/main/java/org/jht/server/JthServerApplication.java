package org.jht.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JthServerApplication {

    @GetMapping("/")
    ResponseEntity<String> get(){
        return ResponseEntity.ok("Hello");
    }

    public static void main(String[] args) {
        SpringApplication.run(JthServerApplication.class, args);
    }

}
