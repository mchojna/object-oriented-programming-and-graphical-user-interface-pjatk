public class Virus implements Flyable{

    protected String naped;
    protected double odleglosc;

    public Virus(){
        this.naped = "kropelkowy";
        this.odleglosc = 1;
    }

    @Override
    public String drive(){
        return this.naped;
    }

    @Override
    public double distance(){
        return this.odleglosc;
    }

    @Override
    public String toString(){
        return "naped: " + this.naped + "\todleglosc: " + this.odleglosc;
    }
}
