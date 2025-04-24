package ClassesPackage;

import EnumsPackage.TypSamochodu;

import java.util.Objects;

public abstract class Samochod {

    protected String marka;
    protected double limit;
    protected TypSamochodu typSamochodu;
    protected Cena cena;

    public Samochod(String marka, double limit, TypSamochodu typSamochodu) {
        if (limit < 0) {
            throw new IllegalArgumentException("Limit musi byc wiekszy lub rowny 0");
        }

        this.marka = marka;
        this.limit = limit;
        this.typSamochodu = typSamochodu;
        this.cena = null;
    }
    public Samochod(String marka, TypSamochodu typSamochodu) {
        this.marka = marka;
        this.limit = 0;
        this.typSamochodu = typSamochodu;
    }
    public static Samochod stworzSamochod(TypSamochodu typSamochodu, String marka){
        return switch(typSamochodu){
            case OSOBOWY -> new Osobowy(marka);
            case DOSTAWCZY -> new Dostawczy(marka);
            case ZABYTKOWY -> new Zabytkowy(marka);
            case DARMO -> new Darmo(marka);
        };
    }

    public void dodajCene(Cena cena) {
        this.cena = cena;
    }

    public Cena zwrocCene(){
        return this.cena;
    }

    public String getMarka() {
        return this.marka;
    }

    public double getLimit() {
        return this.limit;
    }

    public TypSamochodu getTypSamochodu() {
        return this.typSamochodu;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public boolean hasCena() {
        return this.cena.hasCenaDlaAbonamenta() || this.cena.hasCenaPrzedLimitem() || this.cena.hasLimit() || this.cena.hasCenaPoLimicie();
    }

    public double zsumujCene(){
        double sumaCen = 0;

        if(this.cena.hasCenaDlaAbonamenta()){
            sumaCen = this.limit * this.cena.getCenaDlaAbonamenta();
        }else if(this.cena.hasLimit() && !this.cena.hasCenaPrzedLimitem() && !this.cena.hasCenaPoLimicie()) {
            sumaCen = 0;
        }else if(this.cena.hasCenaPrzedLimitem() && this.cena.hasCenaPoLimicie() && this.cena.getCenaPrzedLimitem() == this.cena.getCenaPoLimicie()){
            sumaCen = this.limit * this.cena.getCenaPrzedLimitem();
        }else if(this.cena.hasCenaPoLimicie()) {
            sumaCen = (this.limit - this.cena.getLimit()) * this.cena.getCenaPoLimicie() + this.cena.getLimit() * this.cena.getCenaPrzedLimitem();
        }else if(this.cena.hasCenaPrzedLimitem()){
            sumaCen = this.limit * this.cena.getCenaPrzedLimitem();
        }

        return sumaCen;
    }

    @Override
    public String toString() {
        String cenaSamochodu = "";

        if(this.cena.hasCenaDlaAbonamenta()){
            cenaSamochodu = "cena: " + String.format("%.2f", this.cena.getCenaDlaAbonamenta()) + " zl";
        }else if(this.cena.hasLimit() && !this.cena.hasCenaPrzedLimitem() && !this.cena.hasCenaPoLimicie()) {
            cenaSamochodu = "cena: " + String.format("%.2f", 0.0) + " zl";
        }else if(this.cena.hasCenaPrzedLimitem() && this.cena.hasCenaPoLimicie() && this.cena.getCenaPrzedLimitem() == this.cena.getCenaPoLimicie()){
            cenaSamochodu = "cena: " + String.format("%.2f", this.cena.getCenaPrzedLimitem()) + " zl";
        }else if(this.cena.hasCenaPoLimicie()) {
            cenaSamochodu = "cena: " + String.format("%.2f", this.cena.getCenaPrzedLimitem()) + " zl (do " + String.format("%.2f", this.cena.getLimit()) + " km), " + String.format("%.2f", this.cena.getCenaPoLimicie()) + " zl (od " + String.format("%.2f", (this.cena.getLimit() + 1.0)) + " km)";
        }else if(this.cena.hasCenaPrzedLimitem()){
            cenaSamochodu = "cena: " + String.format("%.2f", this.cena.getCenaPrzedLimitem()) + " zl";
        }else{
            cenaSamochodu = "cena: brak";
        }

        return this.marka + ", typ: " + this.typSamochodu + ", ile: " + String.format("%.2f", this.limit) + " km, " + cenaSamochodu;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        Samochod samochod = (Samochod) o;
        return Objects.equals(marka, samochod.marka) && typSamochodu == samochod.typSamochodu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(marka, typSamochodu);
    }
}
