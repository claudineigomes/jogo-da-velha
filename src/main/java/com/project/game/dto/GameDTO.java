package com.project.game.dto;

import java.util.UUID;

public class GameDTO {
    UUID id;
    String firstPlayer;

    public GameDTO() {
    }

    public GameDTO(UUID id, String firstPlayer) {
        this.id = id;
        this.firstPlayer = firstPlayer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(String firstPlayer) {
        this.firstPlayer = firstPlayer;
    }
}
