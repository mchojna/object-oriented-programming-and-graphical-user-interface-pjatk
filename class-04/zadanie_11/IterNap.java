import java.util.Iterator;

public class IterNap implements java.lang.Iterable<Character> {

    private String slowo;
    private int poczatek = 0;
    private int krok = 1;

    public IterNap(String slowo){
        this.slowo = slowo;
    }

    public void ustawPoczatek(int poczatek){
        this.poczatek = poczatek;
    }

    public void ustawKrok(int krok){
        this.krok = krok;
    }

    @Override
    public Iterator<Character> iterator() {
        return new IterNapIterator(this.slowo, this.poczatek, this.krok);
    }
}