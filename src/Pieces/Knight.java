package Pieces;

public class Knight extends Piece {
    public Knight(int y, int x, boolean white) {
        this.x = x;
        this.y = y;
        this.white = white;
    }

    public boolean checkValidMove(int y, int x, Piece[][] board) {
        //Defaulted Moves
        if ((this.x + 2 == x && this.y + 1 == y) || (this.x + 1 == x && this.y + 2 == y) || (this.x - 2 == x && this.y - 1 == y) || (this.x - 1 == x && this.y - 2 == y) || (this.x + 2 == x && this.y - 1 == y) || (this.x + 1 == x && this.y - 2 == y) || (this.x - 2 == x && this.y + 1 == y) || (this.x - 1 == x && this.y + 2 == y)) {
            return true;
        }

        //Defaults False
        return false;
    }
}
