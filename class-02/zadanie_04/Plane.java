public class Plane implements Flyable, Speakable {

    protected String naped;
    protected double odleglosc;
    protected String odglos;

    public Plane(){
        this.naped = "silnik odrzutowy";
        this.odleglosc = 1000;
        this.odglos = "brum brum";
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
    public String speak(){
        return this.odglos;
    }

    @Override
    public String toString(){
        return "naped: " + this.naped + "\todleglosc: " + this.odleglosc;
    }
}
