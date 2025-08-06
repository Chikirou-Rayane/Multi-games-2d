package Pieces;
import main.Board ;

import java.awt.image.BufferedImage;
public class Knight extends Piece {
    public Knight(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.boxSize;
        this.yPos = row * board.boxSize;
        this.isWhite = isWhite;
        this.name = "Knight";
        if (sheet != null) {
            this.sprite = sheet.getSubimage(3 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.boxSize, board.boxSize, BufferedImage.SCALE_SMOOTH);
        }
    }

    public boolean isValidMovement( int col , int row ){
        return Math.abs( this.col -col ) * Math.abs(this.row - row) == 2  ; }
}
