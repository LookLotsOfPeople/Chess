import Pieces.*;

public class Board {
    private Piece[][] board;
    private boolean hasFocus = false;
    private Piece focus;
    private boolean currentColorWhite = true;

    Board() {
        this.board = new Piece[8][8];
    }

    public void setup() {
        //Clears Board
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                board[y][x] = null;
            }
        }

        //White Pieces
        //Pawns
        for (int i = 0; i < board[6].length; i++) {
            board[6][i] = new Pawn(6, i, true);
        }

        //Rooks
        board[7][0] = new Rook(7, 0, true);
        board[7][7] = new Rook(7, 7, true);

        //Knights
        board[7][1] = new Knight(7, 1, true);
        board[7][6] = new Knight(7, 6, true);

        //Bishops
        board[7][2] = new Bishop(7, 2, true);
        board[7][5] = new Bishop(7, 5, true);

        //Queen
        board[7][3] = new Queen(7, 3, true);

        //King
        board[7][4] = new King(7, 4, true);


        //Black Pieces
        //Pawns
        for (int i = 0; i < board[1].length; i++) {
            board[1][i] = new Pawn(1, i, false);
        }

        //Rooks
        board[0][0] = new Rook(0, 0, false);
        board[0][7] = new Rook(0, 7, false);

        //Knights
        board[0][1] = new Knight(0, 1, false);
        board[0][6] = new Knight(0, 6, false);

        //Bishops
        board[0][2] = new Bishop(0, 2, false);
        board[0][5] = new Bishop(0, 5, false);

        //Queen
        board[0][3] = new Queen(0, 3, false);

        //King
        board[0][4] = new King(0, 4, false);
    }

    public void mouseClickedEvent(int y, int x) {
        if (hasFocus) {
            Piece tempDyingPiece = null;
            if (board[y][x] != null) {
                if (currentColorWhite != board[y][x].isWhite()) {
                    tempDyingPiece = board[y][x];
                } else {
                    focus = board[y][x];
                    return;
                }
            }
            Piece tempFocus = focus;
            if (focus.checkValidMove(y, x, board)) {
                board[y][x] = focus;
                board[focus.getY()][focus.getX()] = null;
                focus.move(y, x);
                if (inCheck()) {
                    focus = tempFocus;
                    board[y][x] = tempDyingPiece;
                    board[focus.getY()][focus.getX()] = focus;
                } else {
                    currentColorWhite = !currentColorWhite;
                    focus = null;
                    hasFocus = false;
                }
            } else {
                focus = null;
                hasFocus = false;
            }
        } else {
            if (board[y][x] != null && currentColorWhite == board[y][x].isWhite()) {
                focus = board[y][x];
                hasFocus = true;
            }
        }
    }

    private boolean inCheck() {
        //Concepts of Check and Checkmate Removed
        return false;
        //TODO Maybe Recover?

//        boolean whiteTerritory[][] = new boolean[board.length][board[0].length];
//        boolean blackTerritory[][] = new boolean[board.length][board[0].length];
//        Piece whiteKing = null;
//        Piece blackKing = null;
//
//        //White Territory
//        for (int y = 0; y < board.length; y++) {
//            for (int x = 0; x < board.length; x++) {
//                if (board[y][x] != null && board[y][x].isWhite()) {
//                    if (board[y][x].getClass().equals(King.class)) {
//                        whiteKing = board[y][x];
//                    }
//                    if (board[y][x].checkValidMove(y, x, board)) {
//                        whiteTerritory[y][x] = true;
//                    }
//                }
//            }
//        }
//
//        //Black Territory
//        for (int y = 0; y < board.length; y++) {
//            for (int x = 0; x < board.length; x++) {
//                if (board[y][x] != null && !board[y][x].isWhite()) {
//                    System.out.println(1);
//                    if (board[y][x].getClass().equals(King.class)) {
//                        blackKing = board[y][x];
//                    }
//                    if (board[y][x].checkValidMove(y, x, board)) {
//                        blackTerritory[y][x] = true;
//                    }
//                }
//            }
//        }
//
//        for (int y = 0; y < whiteTerritory.length; y++) {
//            for (int x = 0; x < whiteTerritory[0].length; x++) {
//                System.out.print(whiteTerritory[y][x]);
//            }
//            System.out.println();
//        }
//
//        if (!currentColorWhite) {
//            return blackTerritory[whiteKing.getY()][whiteKing.getX()];
//        } else {
//            return whiteTerritory[blackKing.getY()][blackKing.getX()];
//        }
    }

    public byte inCheckmate() {
        boolean w = false;
        boolean b = false;
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] != null && board[y][x].getClass().equals(King.class) && board[y][x].isWhite()) {
                    w = true;
                }
            }
        }
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] != null && board[y][x].getClass().equals(King.class) && !board[y][x].isWhite()) {
                    b = true;
                }
            }
        }
        if (!w) {
            return 2;
        } else if (!b) {
            return 1;
        } else {
            return 0;
        }
    }

    public Piece[][] getBoard() {
        return board;
    }

    public boolean isHasFocus() {
        return hasFocus;
    }

    public Piece getPiece(int y, int x) {
        return board[y][x];
    }

    public int getFocusY() {
        return focus.getY();
    }

    public int getFocusX() {
        return focus.getX();
    }
}
