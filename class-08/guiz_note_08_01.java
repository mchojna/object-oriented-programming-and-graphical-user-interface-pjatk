import java.awt.*;
import javax.swing.*;

public class SwingApp {

    public static void main(String[] args)
    {
    	new SwingApp();
    }
    
    public SwingApp()
    {
            // poprawny sposób uruchomienia Swing'a
    	SwingUtilities.invokeLater(this::createGUI);        // () -> createGUI()
    }
    
    protected void createGUI()
    {
    		// utworzenie okna typu JFrame
        JFrame jf = new JFrame();
      
        	// określenie tytułu okna typu JFrame
        jf.setTitle("Simple Swing App");
    
      		// obsługa zamknięcia okna typu JFrame
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // okienka dialogowe do wprawadzenia danych
        String x = JOptionPane.showInputDialog("Podaj położenie x okna");
        String y = JOptionPane.showInputDialog("Podaj położenie y okna");
        
        	// określenie położenia okna typu JFrame
        jf.setLocation(Integer.parseInt(x), Integer.parseInt(y));
        
        	// dodatkowy panel do grupowania komponentów
        JPanel jp = new JPanel();
        
        	// ustawianie zarządcy rozkładu (layout) dla panelu
        jp.setLayout(new GridLayout(2, 3, 2, 2));
        
        	// dodawanie komponentów do panelu
        for (int i = 0; i < 6; i++)
        	jp.add(new JButton(""+i));
        
        	// ustawianie zarządcy rozkladu (layout) dla okna typu JFrame
        jf.setLayout(new FlowLayout(FlowLayout.CENTER));
             
        	// dodawanie komponentów do okna typu JFrame
        jf.add(jp);
        jf.add(new JButton("7"));
        
        	// nie działa
        jf.setBackground(Color.RED);
        	
        	// działa
        //jf.getContentPane().setBackground(Color.RED);
        
        	// ustawianie możliwości zmiany rozmiarów okna typu JFrame
        jf.setResizable(true);
        
        	// upakowanie okna tyou JFrame
        jf.pack();
        	
        	// wyświetlenie okna typu JFrame
        jf.setVisible(true);   
    }
}