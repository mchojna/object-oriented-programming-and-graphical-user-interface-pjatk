package ComponentsPackage;

import EnumsPackage.State;
import FiguresPackage.Circle;
import FiguresPackage.Figure;
import FiguresPackage.Line;
import FiguresPackage.Square;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class FileMenu extends JMenu {

    private MainFrame mainFrame;
    private DrawPanel drawPanel;
    private ToolBar toolBar;

    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenuItem saveAsItem;
    private JMenuItem quitItem;
    private JFileChooser fileChooser;

    public FileMenu(MainFrame mainFrame, DrawPanel drawPanel, ToolBar toolBar){
        this.mainFrame = mainFrame;
        this.drawPanel = drawPanel;
        this.toolBar = toolBar;

        this.fileChooser = new JFileChooser();
        this.fileChooser.setCurrentDirectory(new File("."));
        this.fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));

        this.setText("File");

        this.setFont(new CustomFont());

        this.setMnemonic(KeyEvent.VK_F);

        // OPEN
        this.openItem = new JMenuItem("Open", KeyEvent.VK_O);
        this.openItem.setFont(new CustomFont());
        this.openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        this.openItem.addActionListener(e -> {
            this.fileChooser.setSelectedFile(new File(""));

            if(this.fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                File selectedFile = this.fileChooser.getSelectedFile();

                try{
                    List<Figure> figuresToRead = new ArrayList<>();

                    Scanner fileReader = new Scanner(selectedFile);

                    while(fileReader.hasNextLine()){
                        String dataToRead = fileReader.nextLine();

                        figuresToRead.add(switch (dataToRead.charAt(0)){
                            case '0' -> Circle.readFigure(dataToRead);
                            case '1' -> Square.readFigure(dataToRead);
                            case '2' -> Line.readFigure(dataToRead);
                            default -> throw new IllegalStateException();
                        });
                    }
                    fileReader.close();

                    mainFrame.getCurrentFigures().clear();
                    mainFrame.getCurrentFigures().addAll(figuresToRead);
                    mainFrame.setCurrentState(State.SAVED);
                    mainFrame.setCurrentFileName(selectedFile.getName());
                    mainFrame.setTitle("Simple Draw: " + mainFrame.getCurrentFileName());
                    drawPanel.repaint();
                    toolBar.updateStateLabel();

                    mainFrame.setLastSavedFigures(mainFrame.getCurrentFigures());

                }catch(FileNotFoundException | IllegalStateException | IllegalArgumentException | ArrayIndexOutOfBoundsException ex){
                    if(!(JOptionPane.showConfirmDialog(null, "The file " + selectedFile.getName() + " does not the have correct format. Do you want to open file again?", "File Reading Error", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == 1)){
                        this.openItem.doClick();
                    }
                }
            }
        });
        this.add(openItem);

        // SAVE
        this.saveItem = new JMenuItem("Save", KeyEvent.VK_S);
        saveItem.setFont(new CustomFont());
        saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        saveItem.addActionListener(e -> {
            if(mainFrame.getCurrentFileName().isEmpty()){
                saveAsItem.doClick();
            }else{
                try {
                    FileWriter fileWriter = new FileWriter(mainFrame.getCurrentFileName());

                    String dataToSave = "";

                    for(Figure figure: mainFrame.getCurrentFigures()){
                        dataToSave += figure.writeFigure();
                        dataToSave += "\n";
                    }

                    fileWriter.write(dataToSave);
                    fileWriter.close();

                    mainFrame.setCurrentState(State.SAVED);
                    drawPanel.repaint();
                    toolBar.updateStateLabel();

                    mainFrame.setLastSavedFigures(mainFrame.getCurrentFigures());

                } catch (IOException ex) {
                    if(!(JOptionPane.showConfirmDialog(null, "The file " + mainFrame.getCurrentFileName() + " cannot be saved. Do you want to save file again?", "File Writing Error", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == 1)){
                        this.saveItem.doClick();
                    }
                }
            }
        });
        this.add(saveItem);

        // SAVE AS
        this.saveAsItem = new JMenuItem("Save As..", KeyEvent.VK_A);
        this.saveAsItem.setFont(new CustomFont());
        this.saveAsItem.setAccelerator(KeyStroke.getKeyStroke("ctrl shift S"));
        this.saveAsItem.addActionListener(e -> {
            this.fileChooser.setSelectedFile(new File("simple_draw_file.txt"));

            if(this.fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

                try {
                    File selectedFile = new File(fileChooser.getSelectedFile().toString());

                    if(selectedFile.getName().length() > 4) {
                        if (!selectedFile.getName().endsWith("txt"))
                            selectedFile = new File(fileChooser.getSelectedFile().toString() + ".txt");

                    }else{
                        selectedFile = new File(fileChooser.getSelectedFile().toString() + ".txt");
                    }

                    if (selectedFile.exists()){
                        if(!(JOptionPane.showConfirmDialog(null,"The file " + selectedFile.getName() + " already exist. Do you want to replace it?", "Confirm Save As", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 1)){
                            selectedFile.delete();
                            selectedFile.createNewFile();

                            FileWriter fileWriter = new FileWriter(selectedFile.getName());

                            String dataToSave = "";

                            for(Figure figure: mainFrame.getCurrentFigures()){
                                dataToSave += figure.writeFigure();
                                dataToSave += "\n";
                            }

                            fileWriter.write(dataToSave);
                            fileWriter.close();

                            mainFrame.setCurrentState(State.SAVED);
                            mainFrame.setCurrentFileName(selectedFile.getName());
                            mainFrame.setTitle("Simple Draw: " + mainFrame.getCurrentFileName());
                            drawPanel.repaint();
                            toolBar.updateStateLabel();

                            mainFrame.setLastSavedFigures(mainFrame.getCurrentFigures());
                        } else {
                            if(!(JOptionPane.showConfirmDialog(null, "The file " + mainFrame.getCurrentFileName() + " cannot be saved. Do you want to save file again?", "File Writing Error", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == 1)){
                                this.saveItem.doClick();
                            }
                        }
                    } else if (selectedFile.createNewFile()) {
                        FileWriter fileWriter = new FileWriter(selectedFile.getName());

                        String dataToSave = "";

                        for(Figure figure: mainFrame.getCurrentFigures()){
                            dataToSave += figure.writeFigure();
                            dataToSave += "\n";
                        }

                        fileWriter.write(dataToSave);
                        fileWriter.close();

                        mainFrame.setCurrentState(State.SAVED);
                        mainFrame.setCurrentFileName(selectedFile.getName());
                        mainFrame.setTitle("Simple Draw: " + mainFrame.getCurrentFileName());
                        drawPanel.repaint();
                        toolBar.updateStateLabel();

                        mainFrame.setLastSavedFigures(mainFrame.getCurrentFigures());
                    }
                } catch (IOException ex) {
                    if(!(JOptionPane.showConfirmDialog(null, "The file " + mainFrame.getCurrentFileName() + " cannot be saved. Do you want to save file again?", "File Writing Error", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == 1)){
                        this.saveItem.doClick();
                    }
                }
            }
        });
        this.add(saveAsItem);

        this.addSeparator();

        // QUIT
        this.quitItem = new JMenuItem("Quit", KeyEvent.VK_Q);
        this.quitItem.setFont(new CustomFont());
        this.quitItem.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
        this.quitItem.addActionListener(e -> {
            if (mainFrame.getCurrentState() != State.SAVED && !(mainFrame.getCurrentState() == State.NEW && mainFrame.getCurrentFigures().isEmpty())){
                if(!(JOptionPane.showConfirmDialog(null, "Current state has not been saved. Do you want to save file?", "Current State ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 1)){
                    this.saveItem.doClick();
                }
            }
            System.exit(0);
        });
        this.add(quitItem);
    }

    public void clickQuitButton(){
        this.quitItem.doClick();
    }
}
