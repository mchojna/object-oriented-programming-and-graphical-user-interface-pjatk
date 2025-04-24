public class Bird implements Flyable, Speakable {

    protected String naped;
    protected double odleglosc;
    protected String odglos;

    public Bird(){
        this.naped = "skrzydla";
        this.odleglosc = 10;
        this.odglos = "cwir cwir";
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
