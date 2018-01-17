package Pieces;

public class Pawn extends Piece {
    public Pawn(int y, int x, boolean white) {
        this.x = x;
        this.y = y;
        this.white = white;
    }

    public boolean checkValidMove(int y, int x, Piece[][] board) {
        //Defaulted Moves
        if (white && ((this.y - 1 == y && board[y][x] == null) || (this.y - 2 == y && !moved && board[y][x] == null && board[y+1][x] == null)) && this.x == x) {
            return true;
        }
        if (!white && ((this.y + 1 == y && board[y][x] == null) || (this.y + 2 == y && !moved && board[y][x] == null && board[y-1][x] == null)) && this.x == x) {
            return true;
        }

        //Special Moves
        //Two Space Movement
        if (white && (this.x - 1 == x || this.x + 1 == x) && (this.y - 1 == y) && (board[y][x] != null || board[y][x] != null)) {
            return true;
        }
        if (!white && (this.x - 1 == x || this.x + 1 == x) && (this.y + 1 == y) && (board[y][x] != null || board[y][x] != null)) {
            return true;
        }
        //TODO EN PASSANT

        //Defaults False
        return false;
    }
}
