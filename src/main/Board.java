package main;

// on crée une classe pour le plateau

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import Pieces.*;

public class Board extends JPanel {
    public int boxSize = 80; // la taille de la cellule
    int rows = 8;
    int columns = 8;
    ArrayList<Piece> pieceList = new ArrayList<>(); // une liste des pieces sur l'echequier
    public Board() { // un constructeur pour l'echequié
        this.setPreferredSize(new Dimension(rows * boxSize, columns * boxSize));
        addPieces();
    }
    public void addPieces() { // ajouter les piéces au plateau
        pieceList.add(new Knight(this, 5, 0, false));
        pieceList.add(new Knight(this, 2, 0, false));
        pieceList.add(new Knight(this, 5, 7, true));
        pieceList.add(new Knight(this, 2, 7, true));

        pieceList.add(new Bishop(this, 6, 0, false));
        pieceList.add(new Bishop(this, 1, 0, false));
        pieceList.add(new Bishop(this, 6, 7, true));
        pieceList.add(new Bishop(this, 1, 7, true));

        pieceList.add(new Rock(this , 7, 0 , false ));
        pieceList.add(new Rock(this , 0, 7 , true ));
        pieceList.add(new Rock(this , 0, 0 , false ));
        pieceList.add(new Rock(this , 7, 7 , true ));

        pieceList.add(new King(this , 4, 0 , false ));
        pieceList.add(new King(this , 4, 7 , true ));

        pieceList.add(new Queen(this , 3, 0 , false ));
        pieceList.add(new Queen(this , 3, 7 , true ));

        pieceList.add(new Pawn(this , 0 , 6 , true  ) ) ;
        pieceList.add(new Pawn(this , 1 , 6 , true  ) ) ;
        pieceList.add(new Pawn(this , 2 , 6 , true  ) ) ;
        pieceList.add(new Pawn(this , 3 , 6 , true  ) ) ;
        pieceList.add(new Pawn(this , 4 , 6 , true  ) ) ;
        pieceList.add(new Pawn(this , 5 , 6 , true  ) ) ;
        pieceList.add(new Pawn(this , 6 , 6 , true  ) ) ;
        pieceList.add(new Pawn(this , 7 , 6 , true  ) ) ;


        pieceList.add(new Pawn(this , 0 , 1 , false  ) ) ;
        pieceList.add(new Pawn(this , 1 , 1 , false  ) ) ;
        pieceList.add(new Pawn(this , 2 , 1 , false  ) ) ;
        pieceList.add(new Pawn(this , 3 , 1 , false  ) ) ;
        pieceList.add(new Pawn(this , 4 , 1 , false  ) ) ;
        pieceList.add(new Pawn(this , 5 , 1 , false  ) ) ;
        pieceList.add(new Pawn(this , 6 , 1 , false  ) ) ;
        pieceList.add(new Pawn(this , 7 , 1 , false  ) ) ;
    }
    public void paintComponent(Graphics g) { // réecrire paintComponent de JPanel
        super.paintComponent(g); // prendre ce qui est dans JPanel
        Graphics2D g2D = (Graphics2D) g; // on castre en 2d
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++) {
                g2D.setColor((c + r) % 2 == 0 ? new Color(184, 184, 158, 255) : new Color(39, 29, 35)); // comme impaire + paire = impaire  ... ça marche on choisi une couleur
                g2D.fillRect(c * boxSize, r * boxSize, boxSize, boxSize);// on utilise la couleur choisi pour peindre
            }
        for (Piece piece : pieceList) {
            piece.paint(g2D);
        }
    }
}
