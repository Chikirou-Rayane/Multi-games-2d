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
            this.name = "king";
            if (sheet != null) {
                this.sprite = sheet.getSubimage(0, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.boxSize, board.boxSize, BufferedImage.SCALE_SMOOTH);
            }
        }
}


