package main;

import Pieces.Piece;

public class CheckScanner {

    Board board ;


    public CheckScanner(Board board){
        this.board = board ;
    }


    public Boolean kingIsChecked(Move move){
        Piece king = board.findKing(move.piece.isWhite) ;
        assert king != null ;

        int kingCol = king.col;
        int kingRow = king.row;

        if ( board.selectedPiece != null && board.selectedPiece.name.equals("King")){
            kingCol = move.newCol ;
            kingRow = move.newRow ;
        }

        return
                hitByRock   (move.newCol, move.newRow, king , kingCol,kingRow, 0 , 1)||
                hitByRock   (move.newCol, move.newRow, king , kingCol,kingRow ,  1 , 0)||
                hitByRock   (move.newCol, move.newRow, king , kingCol,kingRow, 0, -1)||
                hitByRock   (move.newCol, move.newRow, king , kingCol,kingRow , -1 , 0)||

                hitByBishop (move.newCol, move.newRow, king , kingCol,kingRow,-1 , -1 ) ||
                hitByBishop (move.newCol, move.newRow, king , kingCol,kingRow, 1 , -1) ||
                hitByBishop (move.newCol, move.newRow, king , kingCol,kingRow, 1 ,1 ) ||
                hitByBishop (move.newCol, move.newRow, king , kingCol,kingRow, -1 , 1) ||

                hitByKnight(move.newCol, move.newRow, king , kingCol,kingRow)||

                hitByPawn(move.newCol, move.newRow, king , kingCol,kingRow ) ||

                hitByKing(king , kingCol , kingRow ) ;





    }

    private boolean hitByRock(int col ,int row , Piece king, int kingCol , int kingRow , int colVal , int rowVal ){
        for ( int i = 1 ; i < 8 ; i++){
            if ( kingCol + (i * colVal) == col && kingRow + ( i*rowVal) == row  ){
                break ;
            }
            Piece piece = board.getPiece(kingRow + ( i*rowVal) , kingCol + (i * colVal)  ) ;
            if ( piece != null && piece != board.selectedPiece){
                if( ! board.sameTeam(piece,king) && ( piece.name.equals("Rock") || piece.name.equals("queen"))){
                    return true ;
                }
                break ;
            }
        }
        return false ;
    }


    private boolean hitByBishop(int col ,int row , Piece king, int kingCol , int kingRow , int colVal , int rowVal ){
        for ( int i = 1 ; i < 8 ; i++){
            if ( kingCol - (i * colVal) == col && kingRow - ( i*rowVal) == row  ){
                break ;
            }
            Piece piece = board.getPiece(kingRow - ( i*rowVal) , kingCol - (i * colVal)  ) ;
            if ( piece != null && piece != board.selectedPiece){
                if( ! board.sameTeam(piece,king) && ( piece.name.equals("Bishop") || piece.name.equals("queen"))){
                    return true ;
                }
                break ;
            }
        }
        return false ;
    }

    private boolean hitByKnight ( int col , int row , Piece king , int kingCol , int kingRow){
        return checkKnight(board.getPiece( kingRow-2 , kingCol -1) , king , col ,row  ) ||
                checkKnight(board.getPiece( kingRow-2, kingCol +1 ) , king , col ,row  ) ||
                checkKnight(board.getPiece(kingRow-1,kingCol +2 ) , king , col ,row  ) ||
                checkKnight(board.getPiece( kingRow+1 , kingCol +2 ) , king , col ,row  ) ||
                checkKnight(board.getPiece( kingRow+2, kingCol +1 ) , king , col ,row  ) ||
                checkKnight(board.getPiece(  kingRow+2 ,kingCol -1 ) , king , col ,row  ) ||
                checkKnight(board.getPiece( kingRow+1, kingCol -2 ) , king , col ,row  ) ||
                checkKnight(board.getPiece(kingRow-1,kingCol -2 ) , king , col ,row  ) ;
    }

    private boolean checkKnight( Piece p , Piece k , int col , int row ){
        return p != null && !board.sameTeam(p,k) && p.name.equals("Knight") && !(p.col == col && p.row == row) ;
    }

    private boolean hitByKing( Piece king , int kingCol , int kingRow ){
        return checkKing( board.getPiece(kingRow-1 , kingCol+1) , king ) ||
                checkKing( board.getPiece(kingRow-1 , kingCol-1) , king ) ||
                checkKing( board.getPiece(kingRow-1 , kingCol) , king ) ||
                checkKing( board.getPiece(kingRow , kingCol-1) , king ) ||
                checkKing( board.getPiece(kingRow , kingCol+1) , king ) ||
                checkKing( board.getPiece(kingRow+1 , kingCol+1) , king ) ||
                checkKing( board.getPiece(kingRow+1 , kingCol-1) , king ) ||
                checkKing( board.getPiece(kingRow+1 , kingCol) , king ) ;
    }


    private boolean checkKing( Piece p , Piece k ) {
        return p != null && ! board.sameTeam(p , k) && p.name.equals("King") ;
    }

    private boolean hitByPawn ( int col , int row , Piece king , int kingCol , int KingRow  ){
        int colorVal = king.isWhite ? -1 : 1 ;
        return checkPawn( board.getPiece(KingRow+colorVal , kingCol - 1) , king , col , row ) ||
                checkPawn( board.getPiece(KingRow+colorVal , kingCol + 1) , king , col , row ) ;
    }

    private boolean checkPawn ( Piece p , Piece k , int col , int row  ) {
        return p != null && !board.sameTeam(p,k) && p.name.equals("Pawn")&&!(p.col == col && p.row == row) ;
    }

}