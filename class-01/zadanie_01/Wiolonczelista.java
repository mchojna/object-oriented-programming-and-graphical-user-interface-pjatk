public class Wiolonczelista extends Muzyk{

    public Wiolonczelista(String imie, double czas){
        super(imie, czas);
        super.stawka = 250;
        super.instrument = "wiolonczela";
    }

    @Override
    public String imie(){
        return super.imie;
    };

    @Override
    public double czas(){
        return super.czas;
    };

    @Override
    public double stawka(){
        return super.stawka;
    };

    @Override
    public String instrument(){
        return super.instrument;
    };
}