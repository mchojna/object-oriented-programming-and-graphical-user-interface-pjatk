package FiguresPackage;

import EnumsPackage.Tool;

import java.awt.*;
import java.util.Objects;

public class Square extends Figure {

    private double s;

    public Square(double x, double y, Color color, double s){
        super(x, y, color, Tool.SQUARE);
        this.s = s;
    }

    public double getS(){
        return s;
    }

    public int calculateLeftUpperCornerX(){
        return (int)(this.x - (this.s / 2.0));
    }

    public int calculateLeftUpperCornerY(){
        return (int)(this.y - (this.s / 2.0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Square square = (Square) o;
        return Double.compare(s, square.s) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), s);
    }

    @Override
    public boolean isRemovable(double corrX, double corrY) {
        return ((this.x - (this.s - 2.0)) <= corrX) &&
                (corrX <= (this.x + (this.s / 2.0))) &&
                ((this.y - (this.s / 2.0)) <= corrY) &&
                (corrY <= (this.y + (this.s / 2.0)));
    }

    @Override
    public String writeFigure() {
        return 1 + "," + (int) this.x + "," + (int) this.y + "," + this.color.getRed() + "," + this.color.getGreen() + "," + this.color.getBlue() + "," + (int) this.s;
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
        double readS = Double.parseDouble(figureArr[6]);

        return new Square(readX, readY, readColor, readS);
    }
}
