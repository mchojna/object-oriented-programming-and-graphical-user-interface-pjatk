package FiguresPackage;

import EnumsPackage.Tool;

import java.awt.*;
import java.util.Objects;

public class Line extends Figure{

    private double x2;
    private double y2;

    public Line(double x1, double y1, double x2, double y2, Color color){
        super(x1, y1, color, Tool.PEN);
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX1(){
        return super.x;
    }

    public double getY1(){
        return super.y;
    }

    public double getX2(){
        return this.x2;
    }

    public double getY2(){
        return this.y2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Line line = (Line) o;
        return Double.compare(x2, line.x2) == 0 && Double.compare(y2, line.y2) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), x2, y2);
    }

    @Override
    public boolean isRemovable(double corrX, double corrY) {
        return false;
    }

    @Override
    public String writeFigure() {
        return 2 + "," + (int) this.x + "," + (int) this.y + "," + (int) this.x2 + "," + (int) this.y2 + "," + this.color.getRed() + "," + this.color.getGreen() + "," + this.color.getBlue();
    }

    public static Figure readFigure(String figureString) {
        String[] figureArr = figureString.split(",");

        double readX1 = Double.parseDouble(figureArr[1]);
        double readY1 = Double.parseDouble(figureArr[2]);
        double readX2 = Double.parseDouble(figureArr[3]);
        double readY2 = Double.parseDouble(figureArr[4]);
        Color readColor = new Color(
                Integer.parseInt(figureArr[5]),
                Integer.parseInt(figureArr[6]),
                Integer.parseInt(figureArr[7])
        );

        return new Line(readX1, readY1, readX2, readY2, readColor);
    }

}
