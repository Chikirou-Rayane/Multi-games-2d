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
    }

