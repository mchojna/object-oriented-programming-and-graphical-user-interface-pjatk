import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class Main{

    String font;
    String format;
    String size;
    
    public static void main(String[] args){

        new Main(args[0], args[1], args[2]);
    }
    
    public Main(String font, String format, String size){
        this.font = font;
        this.format = format;
        this.size = size;

        SwingUtilities.invokeLater(this::createGUI);
    }

    protected void createGUI(){
        JFrame jf = new JFrame();
        jf.setTitle("Zadanie 20 (Elementarne właściwości komponentów)");

        JTextArea jta = new JTextArea();

        Font font = Font.decode(this.font.toUpperCase() + "-" + this.format.toUpperCase() + "-" + this.size);
        jta.setFont(font);

        Color k = JColorChooser.showDialog(null, "Wybierz", Color.BLUE);
        jta.setBackground(k);

        jf.add(jta);

        jf.setSize(new Dimension(480, 480));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}