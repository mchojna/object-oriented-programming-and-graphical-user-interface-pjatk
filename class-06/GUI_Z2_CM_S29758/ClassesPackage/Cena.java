package ClassesPackage;

public class Cena {

    protected double cenaDlaAbonamenta;
    protected double cenaPrzedLimitem;
    protected double limit;
    protected double cenaPoLimicie;

    public Cena(double cenaDlaAbonamenta, double cenaPrzedLimitem, double limit, double cenaPoLimicie) {
        this.cenaDlaAbonamenta = cenaDlaAbonamenta;
        this.cenaPrzedLimitem = cenaPrzedLimitem;
        this.limit = limit;
        this.cenaPoLimicie = cenaPoLimicie;
    }

    public boolean hasCenaDlaAbonamenta() {
        return this.cenaDlaAbonamenta != -1;
    }

    public boolean hasCenaPrzedLimitem() {
        return this.cenaPrzedLimitem != -1;
    }

    public boolean hasLimit() {
        return this.limit != -1;
    }

    public boolean hasCenaPoLimicie() {
        return this.cenaPoLimicie != -1;
    }

    public double getCenaDlaAbonamenta() {
        return this.cenaDlaAbonamenta;
    }

    public double getCenaPrzedLimitem() {
        return this.cenaPrzedLimitem;
    }

    public double getLimit() {
        return this.limit;
    }

    public double getCenaPoLimicie() {
        return this.cenaPoLimicie;
    }
}