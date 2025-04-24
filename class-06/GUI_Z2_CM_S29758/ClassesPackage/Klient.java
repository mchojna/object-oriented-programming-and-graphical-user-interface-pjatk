package ClassesPackage;

import EnumsPackage.TypPlatnosci;
import EnumsPackage.TypSamochodu;

import static EnumsPackage.TypSamochodu.DARMO;

public class Klient {

    protected String identyfikator;
    protected double srodki;
    protected boolean abonament;
    protected ListaZyczen listaZyczen;
    protected Koszyk koszyk;

    public Klient(String identyfikator, double srodki, boolean abonament) {
        if (srodki <= 0) {
            throw new IllegalArgumentException("Srodki musza byc wieksze od 0");
        }

        this.identyfikator = identyfikator;
        this.srodki = srodki;
        this.abonament = abonament;
        this.listaZyczen = new ListaZyczen(this);
        this.koszyk = new Koszyk(this);
    }

    public String pobierzPortfel() {
        return String.format("%.2f", this.srodki);
    }

    public String getIdentyfikator() {
        return this.identyfikator;
    }

    public boolean hasAbonament() {
        return this.abonament;
    }

    public ListaZyczen pobierzListeZyczen() {
        this.zaktualizujCeny();
        return this.listaZyczen;
    }

    public Koszyk pobierzKoszyk() {
        this.zaktualizujCeny();
        return this.koszyk;
    }

    private void zaktualizujCeny(){
        for(Samochod samochod: this.listaZyczen){
            Cennik.obliczCene(samochod, this);
        }
        for(Samochod samochod: this.koszyk){
            Cennik.obliczCene(samochod, this);
        }
    }

    public void dodaj(Samochod samochod) {
        Cennik.obliczCene(samochod, this);
        listaZyczen.dodajDoListy(samochod);
    }

    public void przepakuj() {
        this.zaktualizujCeny();
        this.koszyk.wyczyscListe();
        this.listaZyczen.zamien(this.koszyk);
    }

    public void zaplac(TypPlatnosci typPlatnosci, boolean sposobZaplaty) {
        this.zaktualizujCeny();

        double prowizja = switch (typPlatnosci) {
            case KARTA -> 1.01;
            case PRZELEW -> 1.00;
        };

        double sumaCen = this.koszyk.zsumujCene() * prowizja;

        if(sumaCen > this.srodki && !sposobZaplaty) {
            this.koszyk.wyczyscListe();

        }else if(sumaCen > this.srodki && sposobZaplaty) {
            this.srodki -= this.koszyk.zoptymalizujCene(this.srodki, this.koszyk, prowizja);

        }else {
            this.srodki -= sumaCen;
            this.koszyk.zapiszPoprzednieZakupy();
            this.koszyk.wyczyscListe();
        }
    }

    public void zwroc(TypSamochodu typSamochodu, String marka, double limit){
        this.srodki += this.koszyk.zwrocSrodki(typSamochodu, marka, limit, this);
    }
}