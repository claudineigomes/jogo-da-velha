package com.project.game.domain;

import java.util.UUID;

public class Room {
    UUID id;
    MatrixGame board;
    String nextPlayer;

    public Room(UUID id, String nextPlayer) {
        this.id = id;
        this.board = new MatrixGame();
        this.nextPlayer = nextPlayer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public MatrixGame getBoard() {
        return board;
    }

    public void setBoard(MatrixGame board) {
        this.board = board;
    }

    public String getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(String nextPlayer) {
        this.nextPlayer = nextPlayer;
    }
}
