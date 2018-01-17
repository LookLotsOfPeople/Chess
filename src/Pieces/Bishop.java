package Pieces;

public class Bishop extends Piece {
    public Bishop(int y, int x, boolean white) {
        this.x = x;
        this.y = y;
        this.white = white;
    }

    public boolean checkValidMove(int y, int x, Piece[][] board) {
        //Defaulted Moves
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

        //Defaults False
        return false;
    }
}
