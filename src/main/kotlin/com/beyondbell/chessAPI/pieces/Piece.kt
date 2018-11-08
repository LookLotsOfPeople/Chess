package com.beyondbell.chessAPI.pieces

import com.beyondbell.chessAPI.Player
import com.beyondbell.chessAPI.errors.NotAValidMove

abstract class Piece(val owner: Player, var x: Int, var y: Int) {
	@Throws (NotAValidMove::class)
	fun move(x: Int, y: Int, board: Array<Array<Piece>>) {
		if (checkValidMove(x, y, board) && !inCheck()) {
			this.x = x
			this.y = y
		} else {
			throw NotAValidMove()
		}
	}

	private fun inCheck() : Boolean {   // TODO
		return false
	}

	abstract fun checkValidMove(x: Int, y: Int, board: Array<Array<Piece>>): Boolean
}