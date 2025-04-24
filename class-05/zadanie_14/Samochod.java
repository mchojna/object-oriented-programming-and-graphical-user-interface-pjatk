package zadanie_14;

public class Samochod {
    protected String marka;
    protected String cena;

    public Samochod(String marka, String cena){
        this.marka = marka;
        this.cena = cena;
    }

    public String getMarka(){
        return this.marka;
    }

    public String getCena(){
        return this.cena;
    }

    @Override
    public String toString(){
        return this.marka + " " + this.cena;
    }
}
