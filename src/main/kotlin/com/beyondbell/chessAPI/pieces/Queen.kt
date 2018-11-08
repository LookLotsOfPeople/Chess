package com.beyondbell.chessAPI.pieces


class Queen(y: Int, x: Int, white: Boolean) : Piece() {
	init {
		this.x = x
		this.y = y
		this.white = white
	}

	override fun checkValidMove(y: Int, x: Int, board: Array<Array<Piece>>): Boolean {
		//Defaulted Moves
		//Diagonal Moves
		for (i in -7..7) {
			if (i != 0 && this.y + i == y && this.x + i == x) {
				for (j in 0 - Math.abs(i) + 1 until Math.abs(i)) {
					if (j != 0 && this.y + j < board.size && this.y + j >= 0 && this.x + j < board[this.y + j].size && this.x + j >= 0 && board[this.y + j][this.x + j] != null) {
						return false
					}
				}
				return true
			}
			if (i != 0 && this.y + i == y && this.x - i == x) {
				for (j in 0 - Math.abs(i) + 1 until Math.abs(i)) {
					if (j != 0 && this.y + j < board.size && this.y + j >= 0 && this.x - j < board[this.y + j].size && this.x - j >= 0 && board[this.y + j][this.x - j] != null) {
						return false
					}
				}
				return true
			}
		}
		//Vertical Moves
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