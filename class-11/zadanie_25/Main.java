import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main extends JFrame{

    public static void main(String[] args){
        SwingUtilities.invokeLater(Main::new);
    }

    public Main(){
        this.setTitle("Quadratic Equation");
        this.setSize(new Dimension(350, 200));
        this.setLayout(new GridLayout(4, 1));

        JLabel screenLabel = new JLabel("");
        screenLabel.setOpaque(true);
        screenLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField aTextField = new JTextField("");
        aTextField.setToolTipText("Enter a");
        aTextField.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField bTextField = new JTextField("");
        bTextField.setToolTipText("Enter b");
        bTextField.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField cTextField = new JTextField("");
        cTextField.setToolTipText("Enter c");
        cTextField.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel equationPanel = new JPanel();
        equationPanel.setLayout(new GridLayout(1, 3));
        equationPanel.add(aTextField);
        equationPanel.add(bTextField);
        equationPanel.add(cTextField);

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(e -> {
            if(aTextField.getText().equals("0")){
                screenLabel.setText("Not a quadratic equation!");
                screenLabel.setBackground(Color.RED);
                screenLabel.setForeground(Color.BLACK);
            }else{
                try{
                    double aValue = Double.parseDouble(aTextField.getText());
                    double bValue = Double.parseDouble(bTextField.getText());
                    double cValue = Double.parseDouble(cTextField.getText());

                    screenLabel.setText(Main.solveEquation(aValue, bValue, cValue));
                    screenLabel.setBackground(Color.WHITE);
                    screenLabel.setForeground(Color.BLUE);

                } catch (NumberFormatException exception){
                    screenLabel.setText("Number format error!");
                    screenLabel.setBackground(Color.RED);
                    screenLabel.setForeground(Color.BLACK);
                }
            }

        });
        solveButton.setMnemonic(KeyEvent.VK_S);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> {
            screenLabel.setText("");
            screenLabel.setBackground(Color.WHITE);
            screenLabel.setForeground(Color.BLACK);
            aTextField.setText("");
            bTextField.setText("");
            cTextField.setText("");
        });
        clearButton.setMnemonic(KeyEvent.VK_C);

        this.add(screenLabel);

        this.add(equationPanel);

        this.add(solveButton);
        this.add(clearButton);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static String solveEquation(double aValue, double bValue, double cValue){
        
        double delta = Math.pow(bValue, 2) - (4.0 * aValue * cValue);

        if (delta < 0){
            return "delta < 0, brak rozwiazan";
        }else{
            DecimalFormat df_obj = new DecimalFormat("#0.00");
            df_obj.setRoundingMode(RoundingMode.FLOOR);
 
            double x1 = (-1.0 * bValue - Math.sqrt(delta)) / (2.0 * aValue);
            // System.out.println(x1);
            
            double x2 = (-1.0 * bValue + Math.sqrt(delta)) / (2.0 * aValue);
            // System.out.println(x2);

            if (delta == 0){
                return "delta = 0, x0 = " + df_obj.format(x1);
            }else{
                return "delta > 0, x1 = " + df_obj.format(x1) + " , x2 = " + df_obj.format(x2);
            }
        }
    }
}