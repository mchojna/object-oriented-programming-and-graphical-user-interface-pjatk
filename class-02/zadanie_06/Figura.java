public abstract class Figura implements Obliczenie{

    protected int wspX;
    protected int wspY;

    public Figura(int wspX, int wspY){
        this.wspX = wspX;
        this.wspY = wspY;
    }

    abstract String nazwa();

    abstract void pozycja(int punktX, int punktY);

    @Override
    public String toString(){
        return "";
    }

}