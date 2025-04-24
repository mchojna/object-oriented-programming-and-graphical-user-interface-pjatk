public class UFO implements Flyable, Speakable {

    protected String naped;
    protected double odleglosc;
    protected String odglos;

    public UFO(){
        this.naped = "silnik kwantowy";
        this.odleglosc = 1000;
        this.odglos = "zzz zzz";
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
