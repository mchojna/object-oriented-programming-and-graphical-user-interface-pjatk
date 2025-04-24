package ClassesPackage;

import EnumsPackage.TypSamochodu;

import java.util.HashMap;
import java.util.Map;

import static EnumsPackage.TypSamochodu.DARMO;

public class Cennik {

    private static Cennik cennik = null;
    private static Map<Samochod, Cena> listaCen;

    private Cennik() {
        listaCen = new HashMap<>();
    }

    public static Cennik pobierzCennik() {
        if(cennik == null) {
            cennik = new Cennik();
        }

        return cennik;
    }

    public static Cena zwrocCene(Samochod samochod) {
        try {
            return listaCen.get(samochod);
        } catch (NullPointerException exception) {
            return null;
        }
    }

    public void dodaj(TypSamochodu typSamochodu, String marka, double cenaDlaAbonamenta, double cenaPrzedLimitem, double limit, double cenaPoLimicie) {
        if (cenaDlaAbonamenta <= 0 || cenaPrzedLimitem <= 0 || limit < 0 || cenaPoLimicie < 0) {
            throw new IllegalArgumentException("Cena dla abonamenta, cena przed limitem, limit, cena po limicie musi byc wieksza od 0");
        }else if (typSamochodu == DARMO) {
            throw new IllegalArgumentException("Typ samochodu nie moze by DARMO");
        }

        Samochod samochod = Samochod.stworzSamochod(typSamochodu, marka);
        Cena cena = new Cena(cenaDlaAbonamenta, cenaPrzedLimitem, limit, cenaPoLimicie);

        listaCen.put(samochod, cena);
    }

    public void dodaj(TypSamochodu typSamochodu, String marka, double cenaPrzedLimitem, double limit, double cenaPoLimicie) {
        if (cenaPrzedLimitem <= 0 || limit < 0 || cenaPoLimicie < 0) {
            throw new IllegalArgumentException("Cena przed limitem, limit, cena po limicie musi byc wieksza od 0");
        }else if (typSamochodu == DARMO) {
            throw new IllegalArgumentException("Typ samochodu nie moze by DARMO");
        }

        Samochod samochod = Samochod.stworzSamochod(typSamochodu, marka);
        Cena cena = new Cena(-1, cenaPrzedLimitem, limit, cenaPoLimicie);

        listaCen.put(samochod, cena);
    }

    public void dodaj(TypSamochodu typSamochodu, String marka, double cenaBezLimitu) {
        if (cenaBezLimitu < 0) {
            throw new IllegalArgumentException("Cena musi byc wieksza od 0");
        }else if (typSamochodu == DARMO) {
            throw new IllegalArgumentException("Typ samochodu nie moze by DARMO");
        }

        Samochod samochod = Samochod.stworzSamochod(typSamochodu, marka);
        Cena cena = new Cena(-1, cenaBezLimitu, 0, cenaBezLimitu);

        listaCen.put(samochod, cena);
    }

    public void dodaj(TypSamochodu typSamochodu, double limit, String marka) {
        if (limit < 0) {
            throw new IllegalArgumentException("Limit musi byc wiekszy od 0");
        }else if (typSamochodu != DARMO) {
            throw new IllegalArgumentException("Typ samochodu musi by DARMO");
        }

        Samochod samochod = Samochod.stworzSamochod(typSamochodu, marka);
        Cena cena = new Cena(-1, 0, limit, 0);

        listaCen.put(samochod, cena);
    }

    public static void obliczCene(Samochod samochod, Klient klient) {
        Cena cenaZCennika = zwrocCene(samochod);
        Cena cenaDlaKlienta;

        if(cenaZCennika != null){
            if(klient.hasAbonament() && cenaZCennika.hasCenaDlaAbonamenta()) {
                cenaDlaKlienta = new Cena(cenaZCennika.getCenaDlaAbonamenta(), -1, -1, -1);

            } else if(samochod.getTypSamochodu() == DARMO) {
                cenaDlaKlienta = new Cena(-1, -1, cenaZCennika.getLimit(), -1);
                samochod.setLimit(cenaZCennika.getLimit());

            } else if(samochod.getLimit() <= cenaZCennika.getLimit()) {
                cenaDlaKlienta = new Cena(-1, cenaZCennika.getCenaPrzedLimitem(), cenaZCennika.getLimit(), -1);

            } else {
                cenaDlaKlienta = new Cena(-1, cenaZCennika.getCenaPrzedLimitem(), cenaZCennika.getLimit(), cenaZCennika.getCenaPoLimicie());

            }
        }else{
            cenaDlaKlienta = new Cena(-1, -1, -1, -1);
        }

        samochod.dodajCene(cenaDlaKlienta);
    }
}