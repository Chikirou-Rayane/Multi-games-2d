package main;

// on crée une classe pour le plateau

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Pieces.Piece ;
import Pieces.Knight ;

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
        pieceList.add(new Knight(this, 2, 0, false));
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
