package Pieces;

public class King extends Piece {
    public King(int y, int x, boolean white) {
        this.x = x;
        this.y = y;
        this.white = white;
    }

    public boolean checkValidMove(int y, int x, Piece[][] board) {
        //Defaulted Moves
        if (!(this.x == x && this.y == y) && ((this.y - 1 == y || this.y == y || this.y + 1 == y) && (this.x - 1 == x || this.x == x || this.x + 1 == x))) {
            System.out.println(100);
            return true;
        }

        //Special Moves
        //TODO Castling

        //Defaults False
        return false;
    }
}
