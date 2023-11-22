package com.RabbitProject.FindRabbit;

//import org.springframework.stereotype.Service;
//
//import java.util.Random;
//
//@Service
//public class RabbitService {
//    private final int lengthOfHolesArray = 100;
//    private Rabbit rabbit;
//    private boolean found;
//
//    public RabbitService() {
//        this.rabbit = new Rabbit();
//        this.rabbit.setPosition(new Random().nextInt(lengthOfHolesArray));
//        this.found = false;
//    }
//
//    public String playGame(int guess) {
//        if (found) {
//
//            return "{Game Over. The rabbit has already been found!}";
//
//        }
//
//        if (checkForRabbit(guess)) {
//            found = true;
//            return "{Congratulations! You found the rabbit at }" + guess + "!";
//        } else {
//            return "{You did not find the rabbit. Current position: }" + rabbit.getPosition();
//
//
//        }
//    }
//
//    private boolean checkForRabbit(int guess) {
//        if (guess == rabbit.getPosition()) {
//            return true;
//        } else {
//            randomHop();
//            return false;
//        }
//    }
//
//    private void randomHop() {
//        if (Math.random() > 0.5) {
//            rabbit.setPosition(Math.min(rabbit.getPosition() + 1, lengthOfHolesArray - 1));
//        } else {
//            rabbit.setPosition(Math.max(rabbit.getPosition() - 1, 0));
//        }
//    }
//
//
//}
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class RabbitService {
    private final int lengthOfHolesArray = 100;
    private Rabbit rabbit;
    private boolean found;

    public RabbitService() {
        this.rabbit = new Rabbit();
        this.rabbit.setPosition(new Random().nextInt(lengthOfHolesArray));
        this.found = false;
    }

    public Map<String, String> playGame(int guess) {
        Map<String, String> response = new HashMap<>();

        if (found) {
            response.put("message", "Game Over. The rabbit has already been found!");
        } else {
            if (checkForRabbit(guess)) {
                found = true;
                response.put("message", "Congratulations! You found the rabbit at " + guess + "!");
            } else {
                randomHop();
                response.put("message", "You did not find the rabbit. Current position: " + rabbit.getPosition());
            }
        }

        return response;
    }

    private boolean checkForRabbit(int guess) {
        if (guess == rabbit.getPosition()) {
            return true;
        } else {
            return false;
        }
    }

    private void randomHop() {
        if (Math.random() > 0.5) {
            rabbit.setPosition(rabbit.getPosition() + 1);
        } else {
            rabbit.setPosition(rabbit.getPosition() - 1);
        }
        rabbit.setPosition(Math.min(rabbit.getPosition(), lengthOfHolesArray - 1));
        rabbit.setPosition(Math.max(0, rabbit.getPosition()));
    }
}
