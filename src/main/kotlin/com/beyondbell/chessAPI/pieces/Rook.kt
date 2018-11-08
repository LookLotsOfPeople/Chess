package com.beyondbell.chessAPI.pieces


class Rook(y: Int, x: Int, white: Boolean) : Piece() {
	init {
		this.x = x
		this.y = y
		this.white = white
	}

	override fun checkValidMove(y: Int, x: Int, board: Array<Array<Piece>>): Boolean {
		//Defaulted Moves
		if (this.x != x && this.y == y) {
			if (this.x > x) {
				for (i in 1 until this.x - x) {
					if (board[this.y][this.x - i] != null) {
						return false
					}
				}
				return true
			} else {
				for (i in 1 until x - this.x) {
					if (board[this.y][this.x + i] != null) {
						return false
					}
				}
				return true
			}
		} else if (this.x == x && this.y != y) {
			if (this.y > y) {
				for (i in 1 until this.y - y) {
					if (board[this.y - i][this.x] != null) {
						return false
					}
				}
				return true
			} else {
				for (i in 1 until y - this.y) {
					if (board[this.y + i][this.x] != null) {
						return false
					}
				}
				return true
			}
		}

		//Defaults False
		return false
	}
}