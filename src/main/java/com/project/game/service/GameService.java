package com.project.game.service;

import com.project.game.domain.MatrixGame;
import com.project.game.domain.Room;
import com.project.game.dto.GameDTO;
import com.project.game.dto.MessageDTO;
import com.project.game.dto.MovementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Service
public class GameService {

    @Autowired
    Map<UUID, Room> board;

    public GameDTO startNewGame() {
        UUID id = UUID.randomUUID();
        String firstPlayer = getRandomPlayer();
        Room room = new Room(id, firstPlayer);
        board.put(id, room);
        return new GameDTO(id, firstPlayer);
    }

    public MessageDTO makeMovement(UUID id, MovementDTO movement) {
        Room room = board.get(id);
        if (room == null) {
            return new MessageDTO("Partida não encontrada", null, null, true);
        } else if (!room.getNextPlayer().equalsIgnoreCase(movement.getPlayer())) {
            return new MessageDTO("Não é turno do jogador", null, null, true);
        } else {
            MatrixGame boardM = room.getBoard();
            int x = movement.getPosition().getX();
            int y = movement.getPosition().getY();
            boardM.setPosicao(x, y, getIntByPlayer(movement.getPlayer()));
            room.setNextPlayer(nextPlayer(movement.getPlayer()));
            if (boardM.ganhou() != 0) {
                return new MessageDTO("Partida finalizada", getPlayerByInt(boardM.ganhou()), null, false);
            }else if (boardM.boardCompleto()) {
                return new MessageDTO("Partida finalizada", null, null, false);
            } else
                return new MessageDTO(null, null, null, false);
        }
    }

    private String getRandomPlayer() {
        String[] strings = new String[]{"X", "Y"};
        Random random = new Random();
        return strings[random.nextInt(strings.length)];
    }

    private String nextPlayer(String currentPlayer) {
        return currentPlayer.equalsIgnoreCase("X") ? "Y" : "X";
    }

    private int getIntByPlayer(String player) {
        return player.equalsIgnoreCase("X") ? 1 : -1;
    }

    private String getPlayerByInt(int player){
        return player == 1 ? "X" : "Y";
    }
}
