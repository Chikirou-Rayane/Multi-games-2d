package Pieces;

import main.Board;

import java.awt.image.BufferedImage;
import main.Board ;

public class Queen extends Piece {
    public Queen(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.boxSize;
        this.yPos = row * board.boxSize;
        this.isWhite = isWhite;
        this.name = "queen";
        if (sheet != null) {
            this.sprite = sheet.getSubimage(sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.boxSize, board.boxSize, BufferedImage.SCALE_SMOOTH);
        }
    }


    public boolean isValidMovement( int col , int row ){
        return this.col == col || this.row == row || Math.abs(this.col - col) == Math.abs(this.row - row)  ;
    }

    public boolean moveCollidesWithPiece( int col , int row ) {
        if (this.col == col || this.row == row) {

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

        }
        else {

            // up left
            if ( this.col > col && this.row > row ) {
                for (int i = 1 ; i < Math.abs(this.col - col) ; i++){
                    if ( board.getPiece( this.row-i , this.col-i) != null ){
                        return true ; }
                }
            }

            // up right
            if ( this.col < col && this.row > row ) {
                for (int i = 1 ; i < Math.abs(this.col - col) ; i++){
                    if ( board.getPiece( this.row-i , this.col+i) != null ){
                        return true ; }
                }
            }

            // down left
            if ( this.col > col && this.row < row ) {
                for (int i = 1 ; i < Math.abs(this.col - col) ; i++){
                    if ( board.getPiece( this.row+i , this.col-i) != null ){
                        return true ; }
                }
            }

            // down right
            if ( this.col < col && this.row < row ) {
                for (int i = 1 ; i < Math.abs(this.col - col) ; i++){
                    if ( board.getPiece( this.row+i , this.col+i) != null ){
                        return true ; }
                }
            }
        }
        return false;
    }
}


