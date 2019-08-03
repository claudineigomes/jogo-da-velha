package com.project.game.dto;

import com.project.game.domain.Position;

import java.util.UUID;

public class MovementDTO {
    UUID id;
    String player;
    Position position;

    public MovementDTO() {
    }

    public MovementDTO(UUID id, String player, Position position) {
        this.id = id;
        this.player = player;
        this.position = position;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
