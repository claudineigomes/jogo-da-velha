package com.project.game;

import com.project.game.domain.Position;
import com.project.game.dto.GameDTO;
import com.project.game.dto.MessageDTO;
import com.project.game.dto.MovementDTO;
import com.project.game.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameApplicationTests {

    @Autowired
    GameService gameService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void simpleCorrectExecution(){
        GameDTO gameDTO = gameService.startNewGame();
        UUID id = gameDTO.getId();
        MessageDTO messageDTO;
        String currentPlayer = gameDTO.getFirstPlayer();

        messageDTO = gameService.makeMovement(id, new MovementDTO(id, currentPlayer, new Position(0,0)));
        currentPlayer = nextPlayer(currentPlayer);
        assertThat(messageDTO.getWinner()).isEqualTo(null);
        messageDTO = gameService.makeMovement(id, new MovementDTO(id, currentPlayer, new Position(1,0)));
        currentPlayer = nextPlayer(currentPlayer);
        assertThat(messageDTO.getWinner()).isEqualTo(null);
        messageDTO = gameService.makeMovement(id, new MovementDTO(id, currentPlayer, new Position(0,1)));
        currentPlayer = nextPlayer(currentPlayer);
        assertThat(messageDTO.getWinner()).isEqualTo(null);
        messageDTO = gameService.makeMovement(id, new MovementDTO(id, currentPlayer, new Position(1,1)));
        currentPlayer = nextPlayer(currentPlayer);
        assertThat(messageDTO.getWinner()).isEqualTo(null);
        messageDTO = gameService.makeMovement(id, new MovementDTO(id, currentPlayer, new Position(0,2)));
        currentPlayer = nextPlayer(currentPlayer);
        assertThat(messageDTO.getWinner()).isEqualTo(gameDTO.getFirstPlayer());

    }

    private String nextPlayer(String player){
        return player.equalsIgnoreCase("X") ? "Y" : "X";
    }

}
