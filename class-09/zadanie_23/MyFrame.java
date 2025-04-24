import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class MyFrame extends JFrame{
    public static void main(String[] args){
        SwingUtilities.invokeLater(MyFrame::new);
    }

    public MyFrame(){
        this.setSize(new Dimension(520, 360));
        this.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 24));

        JScrollPane scrollPane = new JScrollPane(textArea);

        this.add(scrollPane, BorderLayout.CENTER);

        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());

        JPanel headerLeft = new JPanel();
        headerLeft.setLayout(new FlowLayout());

        JPanel headerRight = new JPanel();
        headerRight.setLayout(new FlowLayout());

        JButton fr = new JButton("FR");
        fr.setBackground(Color.RED);
        fr.setOpaque(true);
        fr.setBorderPainted(false);

        fr.addActionListener(event -> {
            textArea.setForeground(Color.RED);
        });

        JButton fg = new JButton("FG");
        fg.setBackground(Color.GREEN);
        fg.setOpaque(true);
        fg.setBorderPainted(false);

        fg.addActionListener(event -> {
            textArea.setForeground(Color.GREEN);
        });
        
        JButton fb = new JButton("FB");
        fb.setBackground(Color.BLUE);
        fb.setOpaque(true);
        fb.setBorderPainted(false);

        fb.addActionListener(event -> {
            textArea.setForeground(Color.BLUE);
        });

        headerLeft.add(fr);
        headerLeft.add(fg);
        headerLeft.add(fb);

        JButton a = new JButton("A");
        JButton b = new JButton("B");
        JButton c = new JButton("C");

        headerRight.add(a);
        headerRight.add(b);
        headerRight.add(c);

        header.add(headerLeft, BorderLayout.WEST);
        header.add(headerRight, BorderLayout.EAST);

        this.add(header, BorderLayout.NORTH);

        JPanel footer = new JPanel();
        footer.setLayout(new BorderLayout());

        JPanel footerLeft = new JPanel();
        footerLeft.setLayout(new GridLayout(3, 3, 1, 1));

        JPanel footerRight = new JPanel();
        footerRight.setLayout(new GridLayout(3, 1, 1, 1));

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");

        footerLeft.add(button1);
        footerLeft.add(button2);
        footerLeft.add(button3);
        footerLeft.add(button4);
        footerLeft.add(button5);
        footerLeft.add(button6);
        footerLeft.add(button7);
        footerLeft.add(button8);
        footerLeft.add(button9);

        JTextField textField1 = new JTextField("Pole tekstowe 1 typu JTextField", 20);
        textField1.setBorder(new LineBorder(Color.CYAN, 1));
        JTextField textField2 = new JTextField("Pole tekstowe 2 typu JTextField", 20);
        textField2.setBorder(new LineBorder(Color.CYAN, 1));
        JTextField textField3 = new JTextField("Pole tekstowe 3 typu JTextField", 20);
        textField3.setBorder(new LineBorder(Color.CYAN, 1));

        InputMap imTF1 = textField1.getInputMap();
        ActionMap amTF1 = textField1.getActionMap();

        imTF1.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "onEnter");
        amTF1.put("onEnter", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(textField1.getText() + "\n");
            }
        });

        InputMap imTF2 = textField2.getInputMap();
        ActionMap amTF2 = textField2.getActionMap();

        imTF2.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "onEnter");
        amTF2.put("onEnter", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(textField2.getText() + "\n");
            }
        });

        InputMap imTF3 = textField3.getInputMap();
        ActionMap amTF3 = textField3.getActionMap();

        imTF3.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "onEnter");
        amTF3.put("onEnter", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(textField3.getText() + "\n");
            }
        });

        footerRight.add(textField1);
        footerRight.add(textField2);
        footerRight.add(textField3);

        footer.add(footerLeft, BorderLayout.WEST);
        footer.add(footerRight, BorderLayout.EAST);

        this.add(footer, BorderLayout.SOUTH);

        this.setTitle("Simple Swing App");
        this.setVisible(true);
        this.setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
    }
}