package ClassesPackage;

import static EnumsPackage.TypSamochodu.ZABYTKOWY;

public class Zabytkowy extends Samochod {

    public Zabytkowy(String marka, double limit) {
        super(marka, limit, ZABYTKOWY);
    }

    public Zabytkowy(String marka) {
        super(marka, 0, ZABYTKOWY);
    }
}