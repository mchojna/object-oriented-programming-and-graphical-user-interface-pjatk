import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Main{

    protected String format;
    public static void main(String[] args){
        new Main(args[0]);
    }

    public Main(String format){
        this.format = format;
        SwingUtilities.invokeLater(this::createGUI);
    }

    public void createGUI(){
        JFrame jf = new JFrame();
        jf.setTitle("Zadanie 21 (Testowanie prostych rozkładów)");

        JPanel jp = new JPanel();
        
        switch(this.format){
            case "A" -> jp.setLayout(new BorderLayout());
            case "B" -> jp.setLayout(new FlowLayout());
            case "C" -> jp.setLayout(new FlowLayout(FlowLayout.LEFT));
            case "D" -> jp.setLayout(new FlowLayout(FlowLayout.RIGHT));
            case "E" -> jp.setLayout(new GridLayout(1, 5));
            case "F" -> jp.setLayout(new GridLayout(5, 1));
            case "G" -> jp.setLayout(new GridLayout(3, 2));
        }

        jp.add(new JButton("Przycisk 1"));
        jp.add(new JButton("P 2"));
        jp.add(new JButton("Większy przycisk numer 3"));
        jp.add(new JButton("Przycisk 4"));
        jp.add(new JButton("P 5"));

        jf.add(jp);

        jf.setSize(new Dimension(400, 400));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // jf.pack();
        jf.setVisible(true);
    }
}