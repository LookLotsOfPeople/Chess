package com.beyondbell.chessAPI.pieces


class King(y: Int, x: Int, white: Boolean) : Piece() {
	init {
		this.x = x
		this.y = y
		this.white = white
	}

	fun checkValidMove(y: Int, x: Int, board: Array<Array<Piece>>): Boolean {
		//Defaulted Moves
		if (!(this.x === x && this.y === y) && (this.y - 1 === y || this.y === y || this.y + 1 === y) && (this.x - 1 === x || this.x === x || this.x + 1 === x)) {
			println(100)
			return true
		}

		//Special Moves
		//TODO Castling

		//Defaults False
		return false
	}
}