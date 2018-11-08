package com.beyondbell.chessAPI.pieces

import java.awt.Color.white


class Pawn(y: Int, x: Int, white: Boolean) : Piece() {
	init {
		this.x = x
		this.y = y
		this.white = white
	}

	fun checkValidMove(y: Int, x: Int, board: Array<Array<Piece>>): Boolean {
		//Defaulted Moves
		if (white && (this.y - 1 === y && board[y][x] == null || this.y - 2 === y && !moved && board[y][x] == null && board[y + 1][x] == null) && this.x === x) {
			return true
		}
		if (!white && (this.y + 1 === y && board[y][x] == null || this.y + 2 === y && !moved && board[y][x] == null && board[y - 1][x] == null) && this.x === x) {
			return true
		}

		//Special Moves
		//Two Space Movement
		if (white && (this.x - 1 === x || this.x + 1 === x) && this.y - 1 === y && (board[y][x] != null || board[y][x] != null)) {
			return true
		}
		return if (!white && (this.x - 1 === x || this.x + 1 === x) && this.y + 1 === y && (board[y][x] != null || board[y][x] != null)) {
			true
		} else false
		//TODO EN PASSANT

		//Defaults False
	}
}