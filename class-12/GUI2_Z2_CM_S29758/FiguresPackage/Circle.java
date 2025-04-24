package FiguresPackage;

import EnumsPackage.Tool;

import java.awt.*;
import java.util.Objects;

public class Circle extends Figure {

    private double r;

    public Circle(double x, double y, Color color, double r){
        super(x, y, color, Tool.CIRCLE);
        this.r = r;
    }

    public double getR(){
        return this.r;
    }

    public double getS(){
        return this.r * 2;
    }

    public int calculateLeftUpperCornerX(){
        return (int)(this.x - this.r);
    }

    public int calculateLeftUpperCornerY(){
        return (int)(this.y - this.r);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(r, circle.r) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), r);
    }

    @Override
    public boolean isRemovable(double corrX, double corrY) {
        return ((Math.pow((corrX - this.x), 2) + Math.pow((corrY - this.y), 2)) <= Math.pow(this.r, 2));
    }

    @Override
    public String writeFigure() {
        return 0 + "," + (int) this.x + "," + (int) this.y + "," + this.color.getRed() + "," + this.color.getGreen() + "," + this.color.getBlue() + "," + (int) this.r;
    }

    public static Figure readFigure(String figureString) {
        String[] figureArr = figureString.split(",");

        double readX = Double.parseDouble(figureArr[1]);
        double readY = Double.parseDouble(figureArr[2]);
        Color readColor = new Color(
                Integer.parseInt(figureArr[3]),
                Integer.parseInt(figureArr[4]),
                Integer.parseInt(figureArr[5])
        );
        double readR = Double.parseDouble(figureArr[6]);

        return new Circle(readX, readY, readColor, readR);
    }

}
