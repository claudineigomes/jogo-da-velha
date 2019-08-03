package com.project.game.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(value = { "error" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDTO {
    String msg;
    String winner;
    String status;
    boolean isError;

    public MessageDTO() {
    }

    public MessageDTO(String msg, String winner, String status, boolean isError) {
        this.msg = msg;
        this.winner = winner;
        this.status = status;
        this.isError = isError;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }
}
