package Echecs.main;

import Echecs.main.Pieces.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Input extends MouseAdapter {

    Board board ;


    public Input ( Board board) {
        this.board = board ;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int col = e.getX()/board.boxSize ;
        int row = e.getY()/board.boxSize ;

        Piece pieceXY = board.getPiece(row , col) ;

        if (pieceXY != null ) {
            board.selectedPiece = pieceXY ;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int col = e.getX()/board.boxSize ;
        int row = e.getY()/board.boxSize ;

        if (board.selectedPiece != null){
         Move move = new Move(board ,board.selectedPiece,col,row) ;

         if ( board.isValidMove(move)){
             board.makeMove(move) ;
         }

         else {
             board.selectedPiece.xPos = board.selectedPiece.col * board.boxSize;
             board.selectedPiece.yPos = board.selectedPiece.row * board.boxSize;
         }


        }

        board.selectedPiece = null ;
        board.repaint() ;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (board.selectedPiece != null) {
            board.selectedPiece.xPos = e.getX() - board.boxSize / 2;
            board.selectedPiece.yPos = e.getY() - board.boxSize / 2;
            board.repaint();
        }
    }


}
