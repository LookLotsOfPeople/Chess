import com.beyondbell.chessAPI.board.Board
import com.beyondbell.chessAPI.player.Player

fun main(args: Array<String>) {
	val pieces = Board.Builder(Board.Builder.BoardType.Regular, Player(), Player()).pieces
	for (row in pieces) {
		for (piece in row) {
			System.out.print("${piece?.javaClass?.simpleName}\t")
		}
		System.out.println()
	}
}