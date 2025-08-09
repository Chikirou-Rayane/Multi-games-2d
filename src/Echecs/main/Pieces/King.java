package Echecs.main.Pieces;

import Echecs.main.Board;
import Echecs.main.Move;

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
            return Math.abs ( this.col - col ) <= 1 && Math.abs(this.row - row ) <= 1 && ( Math.abs(this.col-col) + Math.abs(this.row-row ) != 0 ) || canCastle(col , row) ;
        }

    public boolean canCastle ( int col , int row){

            if (this.row == row ) {
                if ( col == 6 ) {
                    Piece rook = board.getPiece(row,7);
                    if( rook != null && rook.isFirstMove && isFirstMove){
                        return board.getPiece(row ,5)== null &&
                                 board.getPiece ( row , 6 ) == null&&
                                 !board.checkScanner.kingIsChecked(new Move(board , this , 5 , row)) ;
                    }
                }
                else if ( col == 2 ) {
                    Piece rook = board.getPiece(row,0);
                    if( rook != null && rook.isFirstMove && isFirstMove){
                        return board.getPiece(row ,3)== null &&
                                board.getPiece ( row , 2 ) == null&&
                                board.getPiece ( row , 1 ) == null&&
                                !board.checkScanner.kingIsChecked(new Move(board , this , 3 , row)) ;
                    }
                }
            }





            return false ;
    }
}



