package ComponentsPackage;

import EnumsPackage.State;
import EnumsPackage.Tool;
import FiguresPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class DrawPanel extends JPanel {

    private Color penColor;

    private int lineHelperX1;
    private int lineHelperY1;
    private int lineHelperX2;
    private int lineHelperY2;

    private boolean keyFigureDelete;
    private boolean mouseFigureDelete;

    private MainFrame mainFrame;
    private ToolBar toolBar;

    public DrawPanel(MainFrame mainFrame, ToolBar toolBar){
        this.penColor = null;

        this.keyFigureDelete = false;
        this.mouseFigureDelete = false;

        this.setPreferredSize(new Dimension(405, 345));

        this.setBackground(Color.WHITE);

        this.mainFrame = mainFrame;
        this.toolBar = toolBar;

        // CIRCLE AND SQUARE
        this.getInputMap(WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0, true), "onF1");
        this.getActionMap().put("onF1", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));

//                System.out.println(getPointerX());
//                System.out.println(getPointerY());

                if(getPointerX() <= 405 && getPointerX() >= 0 && getPointerY() <= 345 && getPointerY() >= 0){
                    switch(mainFrame.getCurrentTool()){
                        case CIRCLE -> {
                            mainFrame.getCurrentFigures().add(new Circle(getPointerX(), getPointerY(), color, 10));
                        }
                        case SQUARE -> {
                            mainFrame.getCurrentFigures().add(new Square(getPointerX(), getPointerY(), color, 20));
                        }
                    }
                    repaint();
                }
            }
        });

        // PEN
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(mainFrame.getCurrentTool() == Tool.PEN){
                    lineHelperX1 = e.getX();
                    lineHelperY1 = e.getY();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(mainFrame.getCurrentTool() == Tool.PEN){
                    repaint();
                }
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(mainFrame.getCurrentTool() == Tool.PEN){
                    lineHelperX2 = e.getX();
                    lineHelperY2 = e.getY();

                    if(getPointerX() <= 405 && getPointerX() >= 0 && getPointerY() <= 345 && getPointerY() >= 0) {
                        mainFrame.getCurrentFigures().add(new Line(lineHelperX1, lineHelperY1, lineHelperX2, lineHelperY2, penColor));
                    }

                    lineHelperX1 = lineHelperX2;
                    lineHelperY1 = lineHelperY2;

                    repaint();
                }
            }
        });

        // DELETE
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(Character.toLowerCase(e.getKeyChar()) == 'd' ){
                    keyFigureDelete = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyChar() == 'd'){
                    keyFigureDelete = false;
                }
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == 1){
                    mouseFigureDelete = true;
                    deleteFigure();
                    mouseFigureDelete = false;
                }
            }
        });
    }

    public void setPenColor(Color color){
        this.penColor = color;
    }

    public Color getPenColor() {
        return penColor;
    }

    private int getPointerX(){
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        Point pointOnScreen = pointerInfo.getLocation();
        int xPanel = getLocationOnScreen().x;

        return  (pointOnScreen.x - xPanel);
    }

    private int getPointerY(){
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        Point pointOnScreen = pointerInfo.getLocation();
        int yPanel = getLocationOnScreen().y;

        return (pointOnScreen.y - yPanel);
    }

    public void deleteFigure(){
        if(this.keyFigureDelete && this.mouseFigureDelete) {
            int pointerX = this.getPointerX();
            int pointerY = this.getPointerY();

            List<Figure> figuresToSave = new ArrayList<>();
            List<Figure> figuresToDelete = new ArrayList<>();

            for (Figure figure : this.mainFrame.getCurrentFigures()) {
                if (figure.isRemovable(pointerX, pointerY)) {
                    figuresToDelete.add(figure);
                } else {
                    figuresToSave.add(figure);
                }
            }

            if (!figuresToDelete.isEmpty()) {
                if (JOptionPane.showConfirmDialog(null, "Do you want to delete figure?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 1) {
                    figuresToSave.addAll(figuresToDelete);
                }
            }

            this.mainFrame.getCurrentFigures().clear();
            this.mainFrame.getCurrentFigures().addAll(figuresToSave);

            this.keyFigureDelete = false;
            this.mouseFigureDelete = false;

            this.repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        for(Figure figure: this.mainFrame.getCurrentFigures()){
            switch (figure.getTool()){
                case CIRCLE -> {
                    Circle circle = (Circle) figure;
                    g2.setColor(circle.getColor());
                    g2.fillOval(circle.calculateLeftUpperCornerX(), circle.calculateLeftUpperCornerY(), (int)(circle.getS()), (int)(circle.getS()));
                }
                case SQUARE -> {
                    Square square = (Square) figure;
                    g2.setColor(square.getColor());
                    g2.fillRect(square.calculateLeftUpperCornerX(), square.calculateLeftUpperCornerY(), (int)(square.getS()), (int)(square.getS()));
                }
                case PEN -> {
                    Line line = (Line) figure;
                    g2.setColor(line.getColor());

                    if(line.getX1() == line.getX2() && line.getY1() == line.getY2()){
                        g2.fillOval((int)(line.getX1()), (int)(line.getY1()), 1, 1);
                    }else{
                        g2.drawLine((int)(line.getX1()), (int)(line.getY1()), (int)(line.getX2()), (int)(line.getY2()));
                    }
                }
            }
        }

        if(this.mainFrame.getCurrentState() == State.SAVED){
            if(!this.mainFrame.getCurrentFigures().equals(this.mainFrame.getLastSavedFigures())){
                this.mainFrame.setCurrentState(State.MODIFIED);
                this.toolBar.updateStateLabel();
            }
        }
    }
}
