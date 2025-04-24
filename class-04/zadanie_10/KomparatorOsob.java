public class KomparatorOsob implements java.util.Comparator<Osoba> {
    
    public Kryterium kryterium;

    public KomparatorOsob(Kryterium kryterium){
        this.kryterium = kryterium;
    }

    public KomparatorOsob() {
    }

    @Override
    public int compare(Osoba o1, Osoba o2) {
        return switch(this.kryterium){
            case Kryterium.imie -> o1.getImie().compareTo(o2.getImie());
            case Kryterium.wiek -> o1.getWiek() - o2.getWiek();
        };
    }

}
