import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{
    public static void main(String[] args){
        new Main();
    }

    public Main(){
        SwingUtilities.invokeLater(this::createGUI);
    }

    public void createGUI(){
        JFrame jf = new JFrame();
        jf.setTitle("Zadanie 22 (Prosta obsługa zdarzeń)");

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());

        JButton button = new JButton("Click me!");

        button.setBackground(Color.RED);
        button.setOpaque(true);
        button.setBorderPainted(false);

        button.addActionListener( new ActionListener() {

            protected Color[] arrColors = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.YELLOW};
            protected int colorIndex = 0;

                @Override
                public void actionPerformed(ActionEvent e){
                    if(colorIndex >= (arrColors.length - 1)) colorIndex = 0;

                    button.setBackground(arrColors[++colorIndex]);
                }
            }
        );

        jp.add(button, BorderLayout.CENTER);
        jf.add(jp);
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(new Dimension(300, 300));
        jf.setVisible(true);
    }
}