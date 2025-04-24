package ComponentsPackage;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    private MainFrame mainFrame;
    private DrawPanel drawPanel;
    private ToolBar toolBar;

    private FileMenu fileMenu;
    private DrawMenu drawMenu;

    public MenuBar(MainFrame mainFrame, DrawPanel drawPanel, ToolBar toolBar){
        this.mainFrame = mainFrame;
        this.drawPanel = drawPanel;
        this.toolBar = toolBar;

        this.fileMenu = new FileMenu(this.mainFrame, this.drawPanel, this.toolBar);
        this.add(fileMenu);

        this.drawMenu = new DrawMenu(this.mainFrame, this.drawPanel, this.toolBar);
        this.add(drawMenu);
    }

    public void clickQuitButton(){
        this.fileMenu.clickQuitButton();
    }
}
