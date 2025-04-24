package FiguresPackage;

import EnumsPackage.Tool;

import java.awt.*;
import java.util.Objects;

public abstract class Figure {

    protected double x;
    protected double y;
    protected Color color;
    protected Tool tool;

    public Figure(double x, double y, Color color, Tool tool){
        this.x = x;
        this.y = y;
        this.color = color;
        this.tool = tool;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public Color getColor(){
        return this.color;
    }

    public Tool getTool() {
        return this.tool;
    }

    public abstract boolean isRemovable(double corrX, double corrY);

    public abstract String writeFigure();

    // public abstract Figure readFigure(String figureString)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Double.compare(x, figure.x) == 0 && Double.compare(y, figure.y) == 0 && Objects.equals(color, figure.color) && tool == figure.tool;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, color, tool);
    }
}
