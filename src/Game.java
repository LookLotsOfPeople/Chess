import Pieces.*;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game extends Applet implements MouseListener{
    //4087729974
    private byte screen = 0;

    private Board board;

    private Font font = new Font("Times New Roman", 0, 80);


    public void init() {
        setFocusable(true);
        resize(800, 800);
        addMouseListener(this);

        board = new Board();
        board.setup();
    }

    public void paint(Graphics g) {
        g.setFont(font);

        if (screen == 0) {
            g.setColor(Color.RED);
            g.fillRect(0, 0, 800, 800);
            g.setColor(Color.GREEN);
            g.drawString("Welcome to Chess", 50, 200);
            g.drawString("Christmas Edition!", 80, 300);
            g.drawString("Click to Begin", 50, 500);
        } else if (screen == 1) {
            //Checks For Checkmate
            if (board.inCheckmate() != 0) {
                screen = 3;
                repaint();
            }

            //Draw Board Background
            boolean tmp = false;
            for (int x = 0; x < 8; x++) {
                tmp = !tmp;
                for (int y = 0; y < 8; y++) {
                    if (tmp) {
                        g.setColor(Color.GRAY);
                    } else {
                        g.setColor(Color.BLACK);
                    }
                    tmp = !tmp;
                    g.fillRect(x*100, y*100, 100, 100);
                }
            }

            //Draws Focus Square
            if (board.isHasFocus()) {
                g.setColor(Color.YELLOW);
                g.fillRect(board.getFocusX() * 100, board.getFocusY() * 100, 100, 100);

            }

            //Draws Pieces
            for (int y = 0; y < board.getBoard().length; y++) {
                for (int x = 0; x < board.getBoard()[0].length; x++) {
                    if (board.getPiece(y, x) != null) {
                        if (board.getPiece(y, x).isWhite()) {
                            g.setColor(Color.RED);
                        } else {
                            g.setColor(Color.GREEN);
                        }
                        if (board.getPiece(y, x).getClass().equals(Pawn.class)) {
                            g.drawString("P", board.getPiece(y, x).getXPos() + 20, board.getPiece(y, x).getYPos() + 80);
                        } else if (board.getPiece(y, x).getClass().equals(Rook.class)) {
                            g.drawString("R", board.getPiece(y, x).getXPos() + 20, board.getPiece(y, x).getYPos() + 80);
                        } else if (board.getPiece(y, x).getClass().equals(Bishop.class)) {
                            g.drawString("B", board.getPiece(y, x).getXPos() + 20, board.getPiece(y, x).getYPos() + 80);
                        } else if (board.getPiece(y, x).getClass().equals(Knight.class)) {
                            g.drawString("N", board.getPiece(y, x).getXPos() + 20, board.getPiece(y, x).getYPos() + 80);
                        } else if (board.getPiece(y, x).getClass().equals(Queen.class)) {
                            g.drawString("Q", board.getPiece(y, x).getXPos() + 20, board.getPiece(y, x).getYPos() + 80);
                        } else if (board.getPiece(y, x).getClass().equals(King.class)) {
                            g.drawString("K", board.getPiece(y, x).getXPos() + 20, board.getPiece(y, x).getYPos() + 80);
                        }
                    }
                }
            }
        } else {
            g.setColor(Color.RED);
            g.fillRect(0, 0, 800, 800);
            g.setColor(Color.GREEN);
            g.drawString("GG!", 200, 200);
            g.drawString("Player " + board.inCheckmate() + " Won!", 50, 300);
            g.drawString("Click to Restart", 50, 500);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (screen == 0 || screen == 2) {
            screen = 1;
            repaint();
        } else if (screen == 1) {
            int y = e.getY() / 100;
            int x = e.getX() / 100;
            board.mouseClickedEvent(y, x);
            repaint();
        } else {
            screen = 1;
            board = new Board();
            board.setup();
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
