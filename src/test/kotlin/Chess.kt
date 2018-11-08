import com.beyondbell.chessAPI.pieces.Bishop
import com.beyondbell.chessAPI.pieces.King
import com.beyondbell.chessAPI.pieces.Knight
import com.beyondbell.chessAPI.pieces.Pawn
import com.beyondbell.chessAPI.pieces.Queen
import com.beyondbell.chessAPI.pieces.Rook
import java.applet.Applet
import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import java.awt.event.MouseEvent
import java.awt.event.MouseListener

fun main(args: Array<String>) {
	Game.start()
}

object Game : Applet(), MouseListener {
	//4087729974
	private var screen: Byte = 0

	private var board: Board? = null

	private val font = Font("Times New Roman", 0, 80)


	override fun init() {
		setFocusable(true)
		resize(800, 800)
		addMouseListener(this)

		board = Board()
		board!!.setup()
	}

	override fun paint(g: Graphics?) {
		g!!.setFont(font)

		if (screen.toInt() == 0) {
			g.setColor(Color.RED)
			g.fillRect(0, 0, 800, 800)
			g.setColor(Color.GREEN)
			g.drawString("Welcome to Chess", 50, 200)
			g.drawString("Christmas Edition!", 80, 300)
			g.drawString("Click to Begin", 50, 500)
		} else if (screen.toInt() == 1) {
			//Checks For Checkmate
			if (board!!.inCheckmate()) {
				screen = 3
				repaint()
			}

			//Draw Board Background
			var tmp = false
			for (x in 0..7) {
				tmp = !tmp
				for (y in 0..7) {
					if (tmp) {
						g!!.setColor(Color.GRAY)
					} else {
						g.setColor(Color.BLACK)
					}
					tmp = !tmp
					g!!.fillRect(x * 100, y * 100, 100, 100)
				}
			}

			//Draws Focus Square
			if (board!!.isHasFocus()) {
				g!!.setColor(Color.YELLOW)
				g!!.fillRect(board!!.getFocusX() * 100, board!!.getFocusY() * 100, 100, 100)

			}

			//Draws Pieces
			for (y in 0 until board!!.getBoard().length) {
				for (x in 0 until board!!.getBoard()[0].length) {
					if (board!!.getPiece(y, x) != null) {
						if (board!!.getPiece(y, x).isWhite()) {
							g!!.setColor(Color.RED)
						} else {
							g!!.setColor(Color.GREEN)
						}
						when {
							board!!.getPiece(y, x) is Pawn -> g!!.drawString("P", board!!.getPiece(y, x).getXPos() + 20, board!!.getPiece(y, x).getYPos() + 80)
							board!!.getPiece(y, x) is Rook -> g!!.drawString("R", board!!.getPiece(y, x).getXPos() + 20, board!!.getPiece(y, x).getYPos() + 80)
							board!!.getPiece(y, x).getClass().equals(Bishop::class.java) -> g!!.drawString("B", board!!.getPiece(y, x).getXPos() + 20, board!!.getPiece(y, x).getYPos() + 80)
							board!!.getPiece(y, x).getClass().equals(Knight::class.java) -> g!!.drawString("N", board!!.getPiece(y, x).getXPos() + 20, board!!.getPiece(y, x).getYPos() + 80)
							board!!.getPiece(y, x).getClass().equals(Queen::class.java) -> g!!.drawString("Q", board!!.getPiece(y, x).getXPos() + 20, board!!.getPiece(y, x).getYPos() + 80)
							board!!.getPiece(y, x).getClass().equals(King::class.java) -> g!!.drawString("K", board!!.getPiece(y, x).getXPos() + 20, board!!.getPiece(y, x).getYPos() + 80)
						}
					}
				}
			}
		} else {
			g!!.setColor(Color.RED)
			g!!.fillRect(0, 0, 800, 800)
			g!!.setColor(Color.GREEN)
			g!!.drawString("GG!", 200, 200)
			g!!.drawString("com.beyondbell.chessAPI.Player " + board!!.inCheckmate() + " Won!", 50, 300)
			g!!.drawString("Click to Restart", 50, 500)
		}
	}

	override fun mouseClicked(e: MouseEvent) {
		if (screen.toInt() == 0 || screen.toInt() == 2) {
			screen = 1
			repaint()
		} else if (screen.toInt() == 1) {
			val y = e.getY() / 100
			val x = e.getX() / 100
			board!!.mouseClickedEvent(y, x)
			repaint()
		} else {
			screen = 1
			board = Board()
			board!!.setup()
			repaint()
		}
	}

	override fun mousePressed(e: MouseEvent) {

	}

	override fun mouseReleased(e: MouseEvent) {

	}

	override fun mouseEntered(e: MouseEvent) {

	}

	override fun mouseExited(e: MouseEvent) {

	}
}