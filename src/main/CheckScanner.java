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
        int kingRow = king.row ;

        if ( board.selectedPiece != null && board.selectedPiece.name.equals("King")){
            kingCol = move.newCol ;
            kingRow = move.newRow ;
        }

        return false ;

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

}
