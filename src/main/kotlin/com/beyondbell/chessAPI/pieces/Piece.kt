package com.beyondbell.chessAPI.pieces

import com.beyondbell.chessAPI.errors.NotAValidMove
import com.beyondbell.chessAPI.player.Player

abstract class Piece(val owner: Player, var x: Int, var y: Int) {
	@Throws (NotAValidMove::class)
	fun move(x: Int, y: Int, board: Array<Array<Piece>>) {
		if (checkValidMove(x, y, board) && !owner.inCheck(board)) {
			val oldX = x
			this.x = x
			val oldY = y
			this.y = y
			if (owner.inCheck(board)) {
				this.x = oldX
				this.y = oldY
				throw NotAValidMove()
			}
		} else {
			throw NotAValidMove()
		}
	}

	abstract fun checkValidMove(x: Int, y: Int, board: Array<Array<Piece>>): Boolean
}