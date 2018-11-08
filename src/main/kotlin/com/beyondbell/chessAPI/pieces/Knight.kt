package com.beyondbell.chessAPI.pieces


class Knight(y: Int, x: Int, white: Boolean) : Piece() {
	init {
		this.x = x
		this.y = y
		this.white = white
	}

	fun checkValidMove(y: Int, x: Int, board: Array<Array<Piece>>): Boolean {
		//Defaulted Moves
		return if (this.x + 2 === x && this.y + 1 === y || this.x + 1 === x && this.y + 2 === y || this.x - 2 === x && this.y - 1 === y || this.x - 1 === x && this.y - 2 === y || this.x + 2 === x && this.y - 1 === y || this.x + 1 === x && this.y - 2 === y || this.x - 2 === x && this.y + 1 === y || this.x - 1 === x && this.y + 2 === y) {
			true
		} else false

		//Defaults False
	}
}