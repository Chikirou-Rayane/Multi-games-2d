package main;

import javax.swing.* ;
import java.awt.*;


public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame(); // initialiser la fenetre

        Board board = new Board() ; // initialiser notre plateau
        frame.add(board); // ajouter le dessin du plateau à la fenetre
        frame.setTitle("My ChessGame"); // donner un titre à la fenetre
        frame.setLayout(new GridBagLayout()); // utiliser ce gestionnaire de disposition
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // quand on ferme la fenetre le programme s'arrete
        frame.getContentPane().setBackground(new Color(133, 21, 21));
        frame.setMinimumSize(new Dimension(1000, 1000)); // donner une taille minimal
        frame.setLocationRelativeTo(null); // metre la fenetre au milieu de l'ecran .
        frame.setVisible(true); // montrer la fentre lors de l'execution

        ImageIcon image = new ImageIcon("src/res/logo.jpg") ; // créer un objet image
        frame.setIconImage(image.getImage()); // changer l'icone de l'image

    }
}
