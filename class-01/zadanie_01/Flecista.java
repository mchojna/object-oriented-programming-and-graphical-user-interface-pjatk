public class Flecista extends Muzyk{

    public Flecista(String imie, double czas){
        super(imie, czas);
        super.stawka = 300;
        super.instrument = "flet";
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
