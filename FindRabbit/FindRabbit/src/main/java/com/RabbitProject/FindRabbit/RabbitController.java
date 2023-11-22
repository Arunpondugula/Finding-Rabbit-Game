package com.RabbitProject.FindRabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/rabbit")
//@CrossOrigin
//public class RabbitController {
//
//    private final RabbitService rabbitService;
//
//    @Autowired
//    public RabbitController(RabbitService rabbitService) {
//        this.rabbitService = rabbitService;
//    }
//
//    @GetMapping("/play/{guess}")
//    public String playGame(@PathVariable int guess) {
//        return rabbitService.playGame(guess);
//    }
//}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/rabbit")
public class RabbitController {

    private final RabbitService rabbitService;

    @Autowired
    public RabbitController(RabbitService rabbitService) {
        this.rabbitService = rabbitService;
    }

    @GetMapping("/play/{guess}")
    public ResponseEntity<Map<String, String>> playGame(@PathVariable int guess) {
        Map<String, String> response = rabbitService.playGame(guess);
        return ResponseEntity.ok(response);
    }
}
