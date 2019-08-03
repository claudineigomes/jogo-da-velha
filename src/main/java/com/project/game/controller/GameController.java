package com.project.game.controller;

import com.project.game.dto.GameDTO;
import com.project.game.dto.MessageDTO;
import com.project.game.dto.MovementDTO;
import com.project.game.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping
    public ResponseEntity<GameDTO> startGame(){
        GameDTO gameDTO = gameService.startNewGame();
        return ResponseEntity.ok().body(gameDTO);
    }

    @PostMapping("/{id}/movement")
    public ResponseEntity<MessageDTO> makeMovement(@PathVariable("id") UUID id, @RequestBody MovementDTO movement){
        MessageDTO messageDTO = gameService.makeMovement(id, movement);
        if(messageDTO.isError()){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(messageDTO);
        }else{
            return ResponseEntity.ok().body(messageDTO);
        }
    }
}
