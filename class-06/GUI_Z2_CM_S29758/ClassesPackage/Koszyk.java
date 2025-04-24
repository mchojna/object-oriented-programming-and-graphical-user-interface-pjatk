package ClassesPackage;

import EnumsPackage.TypSamochodu;

import java.util.ArrayList;
import java.util.List;

public class Koszyk extends Lista {

    protected List<Samochod> poprzednieZakupy;

    public Koszyk(Klient klient) {
        super(klient);
        this.poprzednieZakupy = null;
    }

    public double zsumujCene(){
        double sumaCen = 0;

        for(Samochod samochod: super.listaSamochodow){
            sumaCen += samochod.zsumujCene();
        }
        return sumaCen;
    }
    public void zapiszPoprzednieZakupy(){
        this.poprzednieZakupy = new ArrayList<>();

        this.poprzednieZakupy.addAll(super.listaSamochodow);
    }

    public double zoptymalizujCene(double limitCeny, Lista koszyk, double prowizja){
        super.listaSamochodow.sort(
                (Samochod s1, Samochod s2) -> (int) (s2.zsumujCene() - s1.zsumujCene())
        );

        this.poprzednieZakupy = new ArrayList<>();

        List<Samochod> listaSamochodowNieDoKupienia = new ArrayList<>();

        double sumaCen = 0;

        for(Samochod samochod: super.listaSamochodow) {

            double nowyLimitKM = 0;
            double staryLimitKM = samochod.getLimit();

            double aktualnaCena = 0;
            samochod.setLimit(0);

            while (nowyLimitKM < staryLimitKM && (sumaCen + aktualnaCena) <= limitCeny) {
                nowyLimitKM += 1;
                samochod.setLimit(nowyLimitKM);

                aktualnaCena = samochod.zsumujCene() * prowizja;
            }

            if ((sumaCen + aktualnaCena) > limitCeny) {
                samochod.setLimit(--nowyLimitKM);
            }

            sumaCen += samochod.zsumujCene() * prowizja;

            this.poprzednieZakupy.add(samochod);

            if (nowyLimitKM < staryLimitKM) {

                Samochod nowySamochod = Samochod.stworzSamochod(samochod.getTypSamochodu(), samochod.getMarka());
                nowySamochod.setLimit(staryLimitKM - nowyLimitKM);

                Cena staraCena = samochod.zwrocCene();
                Cena nowaCena = new Cena(staraCena.cenaDlaAbonamenta, staraCena.getCenaPrzedLimitem(), (staryLimitKM - nowyLimitKM), staraCena.getCenaPoLimicie());

                nowySamochod.dodajCene(nowaCena);

                listaSamochodowNieDoKupienia.add(nowySamochod);
            }
        }

        koszyk.wyczyscListe();

        for(Samochod samochod: listaSamochodowNieDoKupienia){
            koszyk.dodajDoListy(samochod);
        }

        return sumaCen;
    }

    public double zwrocSrodki(TypSamochodu typSamochodu, String marka, double limit, Klient klient){
        double sumaDoZwrotu = 0;

        Samochod samochodDoZwrotu = Samochod.stworzSamochod(typSamochodu, marka);

        if(this.poprzednieZakupy.contains(samochodDoZwrotu)){

            int indexSamochoduPoprzednieZakupy = this.poprzednieZakupy.indexOf(samochodDoZwrotu);

            if(this.poprzednieZakupy.get(indexSamochoduPoprzednieZakupy).getLimit() >= limit) {
                double limitPoprzednieZakupy = this.poprzednieZakupy
                        .get(indexSamochoduPoprzednieZakupy)
                        .getLimit();

                this.poprzednieZakupy
                        .get(indexSamochoduPoprzednieZakupy)
                        .setLimit(limitPoprzednieZakupy - limit);

                if(!super.listaSamochodow.contains(samochodDoZwrotu)){
                    super.listaSamochodow.add(samochodDoZwrotu);
                    samochodDoZwrotu.setLimit(0);
                    Cennik.obliczCene(samochodDoZwrotu, klient);
                }

                int indexSamochoduListaSamochodow = super.listaSamochodow.indexOf(samochodDoZwrotu);

                double limitPozostaly = super.listaSamochodow
                        .get(indexSamochoduListaSamochodow)
                        .getLimit();

                if(this.poprzednieZakupy.get(indexSamochoduPoprzednieZakupy).zwrocCene().hasCenaPrzedLimitem() && this.poprzednieZakupy.get(indexSamochoduPoprzednieZakupy).zwrocCene().hasCenaPoLimicie() &&
                        this.poprzednieZakupy.get(indexSamochoduPoprzednieZakupy).zwrocCene().getCenaPrzedLimitem() != this.poprzednieZakupy.get(indexSamochoduPoprzednieZakupy).zwrocCene().getCenaPoLimicie()) {

                    // srodki do zwrotu = pierwotny limit - (pierwotny limit - limit do oddania)

                    super.listaSamochodow.
                            get(indexSamochoduListaSamochodow)
                            .setLimit(limit);

                    samochodDoZwrotu.setLimit(limitPoprzednieZakupy);
                    Cennik.obliczCene(samochodDoZwrotu, klient);

                    sumaDoZwrotu += super.listaSamochodow
                            .get(indexSamochoduListaSamochodow)
                            .zsumujCene();

                    samochodDoZwrotu.setLimit(limitPoprzednieZakupy - limit);
                    Cennik.obliczCene(samochodDoZwrotu, klient);

                    sumaDoZwrotu -= super.listaSamochodow
                            .get(indexSamochoduListaSamochodow)
                            .zsumujCene();

                    samochodDoZwrotu.setLimit(0);
                    Cennik.obliczCene(samochodDoZwrotu, klient);
                }else{
                    super.listaSamochodow.
                            get(indexSamochoduListaSamochodow)
                            .setLimit(limit);

                    sumaDoZwrotu += super.listaSamochodow
                            .get(indexSamochoduListaSamochodow)
                            .zsumujCene();
                }

                super.listaSamochodow
                        .get(indexSamochoduListaSamochodow)
                        .setLimit(limitPozostaly + limit);

            }else {
                samochodDoZwrotu.setLimit(0);
                Cennik.obliczCene(samochodDoZwrotu, klient);
                System.out.println(samochodDoZwrotu + " nie zostal zakupiony w trakcie poprzednich zakupow!");
            }
        }else {
            samochodDoZwrotu.setLimit(0);
            Cennik.obliczCene(samochodDoZwrotu, klient);
            System.out.println(samochodDoZwrotu + " nie zostal zakupiony w trakcie poprzednich zakupow!");
        }
        return sumaDoZwrotu;
    }
}
