package ComponentsPackage;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar {

    private JLabel toolLabel;
    private JLabel stateLabel;

    private MainFrame mainFrame;

    public ToolBar(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        this.setLayout(new BorderLayout());

        this.toolLabel = new JLabel("");
        this.toolLabel.setFont(new CustomFont());
        this.add(this.toolLabel, BorderLayout.WEST);

        this.addSeparator();

        this.stateLabel = new JLabel("New");
        this.stateLabel.setFont(new CustomFont());
        this.add(this.stateLabel, BorderLayout.EAST);
    }

    public void updateToolLabel(){
        this.toolLabel.setText(
                switch (mainFrame.getCurrentTool()){
                    case NONE -> "";
                    case CIRCLE -> "Circle";
                    case SQUARE -> "Square";
                    case PEN -> "Pen";
                }
        );
    }

    public void updateStateLabel(){
        this.stateLabel.setText(
                switch (mainFrame.getCurrentState()){
                    case NEW -> "New";
                    case MODIFIED -> "Modified";
                    case SAVED -> "Saved";
                }
        );
    }
}
