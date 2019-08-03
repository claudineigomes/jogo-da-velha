package com.project.game;

import com.project.game.domain.MatrixGame;
import com.project.game.domain.Room;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
public class GameApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameApplication.class, args);
    }


    @Bean("board")
    public Map<UUID, Room> board (){
        return new HashMap<>();
    }
}
