package ClassesPackage;

import static EnumsPackage.TypSamochodu.DOSTAWCZY;

public class Dostawczy extends Samochod {

    public Dostawczy(String marka, double limit) {
        super(marka, limit, DOSTAWCZY);
    }

    public Dostawczy(String marka) {
        super(marka, 0, DOSTAWCZY);
    }
}