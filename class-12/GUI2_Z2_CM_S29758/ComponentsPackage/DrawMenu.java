package ComponentsPackage;

import EnumsPackage.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class DrawMenu extends JMenu {

    private MainFrame mainFrame;
    private DrawPanel drawPanel;
    private ToolBar toolBar;

    private JMenu figureMenu;
    private ButtonGroup buttonGroup;
    private JRadioButtonMenuItem circleButton;
    private JRadioButtonMenuItem squareButton;
    private JRadioButtonMenuItem penButton;
    private JMenuItem colorItem;
    private JMenuItem clearItem;

    public DrawMenu(MainFrame mainFrame, DrawPanel drawPanel, ToolBar toolBar){
        this.mainFrame = mainFrame;
        this.drawPanel = drawPanel;
        this.toolBar = toolBar;

        this.setText("Draw");

        this.setFont(new CustomFont());

        this.setMnemonic(KeyEvent.VK_D);

        // FIGURE
        this.figureMenu = new JMenu("Figure");
        this.figureMenu.setFont(new CustomFont());
        this.figureMenu.setMnemonic(KeyEvent.VK_F);

        // COLOR
        this.colorItem = new JMenuItem("Color", KeyEvent.VK_O);
        this.colorItem.setFont(new CustomFont());
        this.colorItem.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
//        ActionListener changePenColorListener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                drawPanel.setPenColor(JColorChooser.showDialog(null, "Choose pen color", drawPanel.getPenColor()));
//            }
//        };
//        this.colorItem.addActionListener(changePenColorListener);
        this.colorItem.addActionListener(e -> {
            drawPanel.setPenColor(JColorChooser.showDialog(null, "Choose pen color", drawPanel.getPenColor()));
            if(drawPanel.getPenColor() == null){
                drawPanel.setPenColor(Color.BLACK);
            }
        });

        // CLEAR
        this.clearItem = new JMenuItem("Clear", KeyEvent.VK_C);
        this.clearItem.setFont(new CustomFont());
        this.clearItem.setAccelerator(KeyStroke.getKeyStroke("ctrl shift C"));
        this.clearItem.addActionListener(e -> {
            mainFrame.getCurrentFigures().clear();
            drawPanel.repaint();
        });

        // FIGURE
        this.buttonGroup = new ButtonGroup();

        this.circleButton = new JRadioButtonMenuItem("Circle");
        this.circleButton.setFont(new CustomFont());
        this.circleButton.setMnemonic(KeyEvent.VK_C);
        this.circleButton.addActionListener(e -> {
            mainFrame.setCurrentTool(Tool.CIRCLE);
            toolBar.updateToolLabel();
        });
        this.circleButton.setAccelerator(KeyStroke.getKeyStroke("ctrl L"));
        this.buttonGroup.add(circleButton);
        this.figureMenu.add(circleButton);

        this.squareButton = new JRadioButtonMenuItem("Square");
        this.squareButton.setFont(new CustomFont());
        this.squareButton.setMnemonic(KeyEvent.VK_R);
        this.squareButton.addActionListener(e -> {
            mainFrame.setCurrentTool(Tool.SQUARE);
            toolBar.updateToolLabel();
        });
        this.squareButton.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
        this.buttonGroup.add(squareButton);
        this.figureMenu.add(squareButton);

        this.penButton = new JRadioButtonMenuItem("Pen");
        this.penButton.setFont(new CustomFont());
        this.penButton.setMnemonic(KeyEvent.VK_P);
        this.penButton.addActionListener(e -> {
            if(drawPanel.getPenColor() == null){
                // changePenColorListener.actionPerformed(new ActionEvent(colorItem, ActionEvent.ACTION_PERFORMED, "Manual Trigger"));
                this.colorItem.doClick();
            }
            mainFrame.setCurrentTool(Tool.PEN);
            toolBar.updateToolLabel();
        });
        this.penButton.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
        this.buttonGroup.add(penButton);
        this.figureMenu.add(penButton);

        this.add(figureMenu);
        this.add(colorItem);
        this.addSeparator();
        this.add(clearItem);
    }
}
