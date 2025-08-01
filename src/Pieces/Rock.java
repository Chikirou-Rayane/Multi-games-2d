package Pieces;

import main.Board;

import java.awt.image.BufferedImage;

public class Rock extends Piece {
    public Rock(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.boxSize;
        this.yPos = row * board.boxSize;
        this.isWhite = isWhite;
        this.name = "Rock";
        if (sheet != null) {
            this.sprite = sheet.getSubimage(4*sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.boxSize, board.boxSize, BufferedImage.SCALE_SMOOTH);
        }
    }

    public boolean isValidMovement( int col , int row ){
        return this.col == col || this.row == row ;
    }

    public boolean moveCollidesWithPiece(int col, int row) {
        // Déplacement vers la gauche
        if (this.col > col) {
            for (int c = this.col - 1; c > col; c--) {
                if (board.getPiece(this.row, c) != null) {
                    return true;
                }
            }
        }

        // Déplacement vers la droite
        if (this.col < col) {
            for (int c = this.col + 1; c < col; c++) {
                if (board.getPiece(this.row, c) != null) {
                    return true;
                }
            }
        }

        // Déplacement vers le haut
        if (this.row > row) {
            for (int r = this.row - 1; r > row; r--) {
                if (board.getPiece(r, this.col) != null) {
                    return true;
                }
            }
        }

        // Déplacement vers le bas
        if (this.row < row) {
            for (int r = this.row + 1; r < row; r++) {
                if (board.getPiece(r, this.col) != null) {
                    return true;
                }
            }
        }

        return false;
    }


}