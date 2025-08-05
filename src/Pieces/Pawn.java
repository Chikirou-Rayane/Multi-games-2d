package Pieces;

import main.Board;

import java.awt.image.BufferedImage;


    public class Pawn extends Piece {
        public Pawn(Board board, int col, int row, boolean isWhite) {
            super(board);
            this.col = col;
            this.row = row;
            this.xPos = col * board.boxSize;
            this.yPos = row * board.boxSize;
            this.isWhite = isWhite;
            this.name = "Pawn";
            if (sheet != null) {
                this.sprite = sheet.getSubimage(sheetScale*5, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.boxSize, board.boxSize, BufferedImage.SCALE_SMOOTH);
            }
        }
        public boolean isValidMovement(int col , int row ) {
            int colorIndex = isWhite ? 1 : -1 ;

            // push pawn (une case en avant)
            if(this.col == col && row == this.row - colorIndex && board.getPiece(row , col) == null){
                return true ;
            }

            // push pawn ( deux cases en avant )
            if( isFirstMove && this.col == col && row == this.row - colorIndex * 2 && board.getPiece(row , col) == null && board.getPiece(row+colorIndex , col)== null){
                return true ;
            }

            // capturer à gauche

            if ( row == this.row-colorIndex && this.col-1 == col && board.getPiece(row,col)!= null  ){
                return true ;
            }

            // capturer à droite

            if ( row == this.row-colorIndex && this.col+1 == col && board.getPiece(row,col)!= null  ){
                return true ;
            }

            // En passant à gauche
            if(board.getTileNum(col,row) == board.enPassantTile && col == this.col -1 && row == this.row - colorIndex && board.getPiece(row +colorIndex, col) != null){
                return true ;
            }


            // En passant à droite
            if(board.getTileNum(col,row) == board.enPassantTile && col == this.col +1 && row == this.row - colorIndex && board.getPiece(row +colorIndex, col) != null){
                return true ;
            }





            return false ;}

    }

