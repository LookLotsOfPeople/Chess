package com.beyondbell.chessAPI.pieces

import com.beyondbell.chessAPI.Player


class Bishop(owner: Player, x: Int, y: Int) : Piece(owner, x, y) {
	override fun checkValidMove(x: Int, y: Int, board: Array<Array<Piece>>): Boolean {
		if (x < 8) {

		}
		if (board[x][y].owner != owner) {
			return Math.abs()
		}
		return false
	}



/*	fun checkValidMove(y: Int, x: Int, board: Array<Array<Piece>>): Boolean {
		//Defaulted Moves
		for (i in -7..7) {
			if (i != 0 && this.y + i === y && this.x + i === x) {
				for (j in 0 - Math.abs(i) + 1 until Math.abs(i)) {
					if (j != 0 && this.y + j < board.size && this.y + j >= 0 && this.x + j < board[this.y + j].size && this.x + j >= 0 && board[this.y + j][this.x + j] != null) {
						return false
					}
				}
				return true
			}
			if (i != 0 && this.y + i === y && this.x - i === x) {
				for (j in 0 - Math.abs(i) + 1 until Math.abs(i)) {
					if (j != 0 && this.y + j < board.size && this.y + j >= 0 && this.x - j < board[this.y + j].size && this.x - j >= 0 && board[this.y + j][this.x - j] != null) {
						return false
					}
				}
				return true
			}
		}

		//Defaults False
		return false
	}*/
}