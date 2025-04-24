import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class MyFrame extends JFrame{
    public static void main(String[] args){
        SwingUtilities.invokeLater(MyFrame::new);
    }

    public MyFrame(){
        this.setTitle("RGB");
        this.setSize(new Dimension(300, 300));
        this.setResizable(false);

        this.setLayout(new BorderLayout());

        JSlider greenSlider = new JSlider(SwingConstants.VERTICAL, 0, 255, 0);
        greenSlider.setBackground(Color.GREEN);
        greenSlider.setOpaque(true);
        greenSlider.setPaintTrack(true);

        JSlider redSlider = new JSlider(SwingConstants.HORIZONTAL, 255, 0);
        redSlider.setBackground(Color.RED);
        redSlider.setOpaque(true);
        redSlider.setPaintTrack(true);

        JSlider blueSlider = new JSlider(SwingConstants.VERTICAL, 0, 255, 0);
        blueSlider.setBackground(Color.BLUE);
        blueSlider.setOpaque(true);
        blueSlider.setPaintTrack(true);
        
        JPanel textPanel = new JPanel();
        textPanel.setBackground(new Color(215, 215, 215));

        JPanel circlePanel = new JPanel();
        circlePanel.add(new Circle(0, 0, 0));

        JLabel greenLabel = new JLabel("Green = " + 0);
        greenLabel.setFont(new Font("Arial", Font.BOLD, 16));
        greenLabel.setForeground(Color.GREEN);

        JLabel redLabel = new JLabel("Red = " + 0);
        redLabel.setFont(new Font("Arial", Font.BOLD, 16));
        redLabel.setForeground(Color.RED);

        JLabel blueLabel = new JLabel("Blue = " + 0);
        blueLabel.setFont(new Font("Arial", Font.BOLD, 16));
        blueLabel.setForeground(Color.BLUE);

        greenSlider.addChangeListener(changeListener -> {
            greenLabel.setText("Green = " + greenSlider.getValue());
            this.updatePanel(circlePanel, redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());
        });

        redSlider.addChangeListener(changeListener -> {
            redLabel.setText("Red = " + redSlider.getValue());
            this.updatePanel(circlePanel, redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());
        });

        blueSlider.addChangeListener(changeListener -> {
            blueLabel.setText("Blue = " + blueSlider.getValue());
            this.updatePanel(circlePanel, redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());
        });

        textPanel.add(redLabel);
        textPanel.add(greenLabel);
        textPanel.add(blueLabel);

        this.add(greenSlider, BorderLayout.WEST);
        this.add(redSlider, BorderLayout.NORTH);
        this.add(blueSlider, BorderLayout.EAST);
        this.add(textPanel, BorderLayout.SOUTH);
        this.add(circlePanel, BorderLayout.CENTER);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void updatePanel(JPanel panel, int r, int g, int b){
        panel.removeAll();
        panel.add(new Circle(r, g, b));
    }
}

class Circle extends JPanel{

    private Color color;

    public Circle(int r, int g, int b){
        setPreferredSize(new Dimension(300, 300));
        this.color = new Color(r, g, b);
    }

    public void paintComponent(Graphics g){
        super.paintComponents(g);

        int width = 200;
        int height = 200;

        g.setColor(this.color);
        g.fillOval(50, 0, width, height);
    }
}