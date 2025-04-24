package ClassesPackage;

import static EnumsPackage.TypSamochodu.OSOBOWY;

public class Osobowy extends Samochod {

    public Osobowy(String marka, double limit) {
        super(marka, limit, OSOBOWY);
    }

    public Osobowy(String marka) {
        super(marka, 0, OSOBOWY);
    }
}