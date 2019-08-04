package com.project.game.domain;

public class MatrixGame {
    int[][] board;

/*  00 01 02
    10 11 12
    20 21 22  */

    public MatrixGame() {
        this.board = new int[3][3];
    }

    public void setPosicao(int x, int y, int jogador){
        if(x == 0 && y == 2){
            x=0;y=0;
        }else if(x == 1 && y == 2){
            x=0;y=1;
        }else if(x == 2 && y == 2){
            x=0;y=2;
        }else if(x == 0 && y == 1){
            x=1;y=0;
        }else if(x == 1 && y == 1){
            x=1;y=1;
        }else if(x == 2 && y == 1){
            x=1;y=2;
        }else if(x == 0 && y == 0){
            x=2;y=0;
        }else if(x == 1 && y == 0){
            x=2;y=1;
        }else if(x == 2 && y == 0){
            x=2;y=2;
        }
        if(jogador == 1)
            board[x][y] = 1;
        else
            board[x][y] = -1;
    }

    public int ganhou() {
        if (checaLinhas() == 1)
            return 1;
        if (checaColunas() == 1)
            return 1;
        if (checaDiagonais() == 1)
            return 1;

        if (checaLinhas() == -1)
            return -1;
        if (checaColunas() == -1)
            return -1;
        if (checaDiagonais() == -1)
            return -1;
        return 0;
    }

    public boolean boardCompleto() {
        for (int linha = 0; linha < 3; linha++)
            for (int coluna = 0; coluna < 3; coluna++)
                if (board[linha][coluna] == 0)
                    return false;
        return true;
    }

    private int checaLinhas() {
        for (int linha = 0; linha < 3; linha++) {
            if ((board[linha][0] + board[linha][1] + board[linha][2]) == -3)
                return -1;
            if ((board[linha][0] + board[linha][1] + board[linha][2]) == 3)
                return 1;
        }
        return 0;
    }

    private int checaColunas() {
        for (int coluna = 0; coluna < 3; coluna++) {
            if ((board[0][coluna] + board[1][coluna] + board[2][coluna]) == -3)
                return -1;
            if ((board[0][coluna] + board[1][coluna] + board[2][coluna]) == 3)
                return 1;
        }
        return 0;
    }

    private int checaDiagonais() {
        if ((board[0][0] + board[1][1] + board[2][2]) == -3)
            return -1;
        if ((board[0][0] + board[1][1] + board[2][2]) == 3)
            return 1;
        if ((board[0][2] + board[1][1] + board[2][0]) == -3)
            return -1;
        if ((board[0][2] + board[1][1] + board[2][0]) == 3)
            return 1;
        return 0;
    }
}
