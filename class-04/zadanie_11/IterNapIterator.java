import java.util.Iterator;

public class IterNapIterator implements Iterator<Character> {
    
    protected String slowo;
    protected int index;
    protected int krok;

    public IterNapIterator(String slowo, int poczatek, int krok){
        this.slowo = slowo;
        this.index = poczatek;
        this.krok = krok;
    }

    @Override
    public boolean hasNext(){
        return this.index < this.slowo.length();
    }

    @Override
    public Character next(){
        int staryIndex = index;
        index = index + krok;

        return this.slowo.charAt(staryIndex);
    }

}
