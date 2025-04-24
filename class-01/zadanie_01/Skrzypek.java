public class Skrzypek extends Muzyk{
    
    public Skrzypek(String imie, double czas){
        super(imie, czas);
        super.stawka = 200;
        super.instrument = "skrzypce";
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
