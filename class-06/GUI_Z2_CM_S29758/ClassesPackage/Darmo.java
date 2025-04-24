package ClassesPackage;

import static EnumsPackage.TypSamochodu.DARMO;

public class Darmo extends Samochod {

    public Darmo(String marka, double limit) {
        super(marka, limit, DARMO);
    }

    public Darmo(String marka) {
        super(marka, 0, DARMO);
    }
}