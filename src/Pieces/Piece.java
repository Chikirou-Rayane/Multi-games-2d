package Pieces;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException ;
import java.util.Objects;
import main.Board ;
public class Piece {
    public int col, row;
    public int xPos, yPos;
    public boolean isWhite;
    public String name;
    public int value;
    BufferedImage sheet; // une image memorisé qui représente le pion
    {
        try {
            sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("pieces.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Image sprite; // on initialise l'image qui va contenir la piece
    Board board; // on initialise le plateau
    protected int sheetScale = sheet != null ? sheet.getWidth() / 6 : 0; // on défini un ecart pour pouvoir prendre les pieces qu'on veut de la photo
    public Piece(Board board) {
        this.board = board;
    }
    public void paint(Graphics2D g2d) {
        if (sprite != null) {
            g2d.drawImage(sprite, xPos, yPos, null);
        }
    }
}
