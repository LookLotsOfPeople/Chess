package Pieces;

public class Queen extends Piece {
    public Queen(int y, int x, boolean white) {
        this.x = x;
        this.y = y;
        this.white = white;
    }

    public boolean checkValidMove(int y, int x, Piece[][] board) {
        //Defaulted Moves
        //Diagonal Moves
        for (int i = -7; i < 8; i++) {
            if (i != 0 && (this.y + i == y && this.x + i == x))  {
                for (int j = 0 - Math.abs(i) + 1; j < Math.abs(i); j++) {
                    if (j != 0 && (this.y + j < board.length && this.y + j >= 0 && this.x + j < board[this.y + j].length && this.x + j >= 0) && (board[this.y + j][this.x + j] != null)) {
                        return false;
                    }
                }
                return true;
            }
            if (i != 0 && (this.y + i == y && this.x - i == x)) {
                for (int j = 0 - Math.abs(i) + 1; j < Math.abs(i); j++) {
                    if (j != 0 && (this.y + j < board.length && this.y + j >= 0 && this.x - j < board[this.y + j].length && this.x - j >= 0) && (board[this.y + j][this.x - j] != null)) {
                        return false;
                    }
                }
                return true;
            }
        }
        //Vertical Moves
        if (this.x != x && this.y == y) {
            if (this.x > x) {
                for (int i = 1; i < this.x - x; i++) {
                    if (board[this.y][this.x - i] != null) {
                        return false;
                    }
                }
                return true;
            } else {
                for (int i = 1; i < x - this.x; i++) {
                    if (board[this.y][this.x + i] != null) {
                        return false;
                    }
                }
                return true;
            }
        } else if (this.x == x && this.y != y) {
            if (this.y > y) {
                for (int i = 1; i < this.y - y; i++) {
                    if (board[this.y - i][this.x] != null) {
                        return false;
                    }
                }
                return true;
            } else {
                for (int i = 1; i < y - this.y; i++) {
                    if (board[this.y + i][this.x] != null) {
                        return false;
                    }
                }
                return true;
            }
        }

        //Defaults False
        return false;
    }
}
