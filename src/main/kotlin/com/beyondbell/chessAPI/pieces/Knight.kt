package com.beyondbell.chessAPI.pieces

import com.beyondbell.chessAPI.player.Player

class Knight(owner: Player, x: Int, y: Int) : Piece(owner, x, y) {
	override fun checkValidMove(x: Int, y: Int, board: Array<Array<Piece>>): Boolean {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
}