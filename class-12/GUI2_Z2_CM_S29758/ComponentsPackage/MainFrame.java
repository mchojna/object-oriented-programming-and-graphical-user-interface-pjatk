package ComponentsPackage;

import EnumsPackage.State;
import EnumsPackage.Tool;
import FiguresPackage.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    private Tool currentTool;
    private State currentState;

    private List<Figure> currentFigures;

    private List<Figure> lastSaveDFigures;

    private String currentFileName;

    private DrawPanel drawPanel;
    private ToolBar toolBar;
    private MenuBar menuBar;

    public MainFrame(){

        this.setTitle("Simple Draw");

        this.setSize(new Dimension(420, 420));

        this.setResizable(false);

        this.currentTool = Tool.NONE;
        this.currentState = State.NEW;

        this.currentFigures = new ArrayList<>();
        this.lastSaveDFigures = new ArrayList<>();

        this.currentFileName = "";

        this.setLayout(new BorderLayout());

        this.toolBar = new ToolBar(this);
        this.add(this.toolBar, BorderLayout.SOUTH);

        this.drawPanel = new DrawPanel(this, this.toolBar);
        this.add(this.drawPanel, BorderLayout.CENTER);

        this.menuBar = new MenuBar(this, this.drawPanel, this.toolBar);
        this.setJMenuBar(this.menuBar);

        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                menuBar.clickQuitButton();
            }
        });

    }

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public String getCurrentFileName() {
        return currentFileName;
    }

    public void setCurrentFileName(String currentFileName) {
        this.currentFileName = currentFileName;
    }

    public List<Figure> getCurrentFigures() {
        return currentFigures;
    }

    public void setCurrentFigures(List<Figure> currentFigures) {
        this.currentFigures.clear();
        this.currentFigures.addAll(currentFigures);
    }

    public List<Figure> getLastSavedFigures() {
        return lastSaveDFigures;
    }

    public void setLastSavedFigures(List<Figure> lastSavedState) {
        this.lastSaveDFigures.clear();
        this.lastSaveDFigures.addAll(lastSavedState);
    }

}
