package com.beyondbell.chessAPI.board

import com.beyondbell.chessAPI.errors.InvalidBoardConfiguration
import com.beyondbell.chessAPI.errors.InvalidPieceOwner
import com.beyondbell.chessAPI.pieces.Bishop
import com.beyondbell.chessAPI.pieces.King
import com.beyondbell.chessAPI.pieces.Knight
import com.beyondbell.chessAPI.pieces.Pawn
import com.beyondbell.chessAPI.pieces.Piece
import com.beyondbell.chessAPI.pieces.Queen
import com.beyondbell.chessAPI.pieces.Rook
import com.beyondbell.chessAPI.player.Player

class Board private constructor(private var pieces: Array<Array<Piece?>>) {
	class Builder(private val boardType: BoardType, private val playerWhite: Player, private val playerBlack: Player) {
		val pieces: Array<Array<Piece?>>

		init {
			when (boardType) {
				BoardType.Empty -> {
					pieces = arrayOf(
							arrayOfNulls(8),
							arrayOfNulls(8),
							arrayOfNulls(8),
							arrayOfNulls(8),
							arrayOfNulls(8),
							arrayOfNulls(8),
							arrayOfNulls(8),
							arrayOfNulls(8)
					)
				}
				BoardType.Regular -> {
					pieces = arrayOf(
							arrayOf<Piece?>(
									Rook(playerBlack, 1, 8),
									Knight(playerBlack, 2, 8),
									Bishop(playerBlack, 3, 8),
									Queen(playerBlack, 4, 8),
									King(playerBlack, 5, 8),
									Rook(playerBlack, 6, 8),
									Knight(playerBlack, 7, 8),
									Bishop(playerBlack, 8, 8)
							),
							arrayOf<Piece?>(
									Pawn(playerBlack, 1, 7),
									Pawn(playerBlack, 2, 7),
									Pawn(playerBlack, 3, 7),
									Pawn(playerBlack, 4, 7),
									Pawn(playerBlack, 5, 7),
									Pawn(playerBlack, 6, 7),
									Pawn(playerBlack, 7, 7),
									Pawn(playerBlack, 8, 7)
							),
							arrayOfNulls(8),
							arrayOfNulls(8),
							arrayOfNulls(8),
							arrayOfNulls(8),
							arrayOf<Piece?>(
									Pawn(playerWhite, 1, 2),
									Pawn(playerWhite, 2, 2),
									Pawn(playerWhite, 3, 2),
									Pawn(playerWhite, 4, 2),
									Pawn(playerWhite, 5, 2),
									Pawn(playerWhite, 6, 2),
									Pawn(playerWhite, 7, 2),
									Pawn(playerWhite, 8, 2)
							),
							arrayOf<Piece?>(
									Rook(playerWhite, 1, 1),
									Knight(playerWhite, 2, 1),
									Bishop(playerWhite, 3, 1),
									Queen(playerWhite, 4, 1),
									King(playerWhite, 5, 1),
									Rook(playerWhite, 6, 1),
									Knight(playerWhite, 7, 1),
									Bishop(playerWhite, 8, 1)
							)
					)
				}
			}
		}

		@Throws(InvalidBoardConfiguration::class)
		fun build(): Board {
			if (!hasOnlyOneKing() || hasIllegalPawns() || inCheckMate()) {
				throw InvalidBoardConfiguration()
			} else {
				return Board(pieces)
			}
		}

		@Throws(InvalidPieceOwner::class)
		fun setPiece(piece: Piece?, x: Int, y: Int) : Builder {
			if (piece != null && (piece.owner != playerWhite && piece.owner != playerBlack)) {
				throw InvalidPieceOwner()
			}

			pieces[y][x] = piece
			return this
		}

		private fun hasOnlyOneKing() : Boolean {
			var whiteKings = 0
			var blackKings = 0
			for (row in pieces) {
				for (piece in row) {
					if (piece is King) {
						when (piece.owner) {
							playerWhite -> whiteKings++
							playerBlack -> blackKings++
						}
					}
				}
			}
			return whiteKings == 1 && blackKings == 1
		}

		private fun hasIllegalPawns() : Boolean {   // In Promoting File

		}

		private fun inCheckMate(): Boolean {
			return playerWhite.inCheckMate(pieces) || playerBlack.inCheckMate(pieces)
		}

		enum class BoardType {
			Empty, Regular,
		}
	}
}