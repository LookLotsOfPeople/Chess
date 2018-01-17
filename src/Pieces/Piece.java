package Pieces;

public class Piece {
    boolean moved = false;
    int x, y;
    boolean white;

    public void move(int y, int x) {
        moved = true;
        this.x = x;
        this.y = y;
    }

    //Must Be Overridden
    public boolean checkValidMove(int y, int x, Piece[][] board) {
        //Defaulted Moves

        //Special Moves

        //Defaults False
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isWhite() {
        return white;
    }

    public int getXPos() {
        return x * 100;
    }

    public int getYPos() {
        return y * 100;
    }
}
