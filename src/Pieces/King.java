package Pieces;

import main.Board;

import java.awt.image.BufferedImage;

public class King extends Piece {
        public King(Board board, int col, int row, boolean isWhite) {
            super(board);
            this.col = col;
            this.row = row;
            this.xPos = col * board.boxSize;
            this.yPos = row * board.boxSize;
            this.isWhite = isWhite;
            this.name = "King";
            if (sheet != null) {
                this.sprite = sheet.getSubimage(0, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.boxSize, board.boxSize, BufferedImage.SCALE_SMOOTH);
            }
        }
    public boolean isValidMovement( int col , int row ) {
            return Math.abs ( this.col - col ) <= 1 && Math.abs(this.row - row ) <= 1 && ( Math.abs(this.col-col) + Math.abs(this.row-row ) != 0 ) ;
        }

    public boolean canCastle ( int col , int row){

            if (this.row == row ) {
                if ( col == 6 ) {

                }
            }




            return false ;
    }
}



