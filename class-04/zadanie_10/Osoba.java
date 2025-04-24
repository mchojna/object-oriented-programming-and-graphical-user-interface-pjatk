public class Osoba implements Comparable<Osoba> {

    private String imie;
    private int wiek;

    public Osoba(String imie, int wiek){
        this.imie = imie;
        this.wiek = wiek;
    }

    @Override
    public String toString(){
        return "(" + this.imie + ", " + this.wiek + ")";
    }

    public String getImie(){
        return this.imie;
    }

    public int getWiek(){
        return this.wiek;
    }

    public int compareTo(Osoba o){
        if(this.getImie().equals(o.getImie())){
            return this.getWiek() - o.getWiek();
        }else{
            return this.getImie().compareTo(o.getImie());
        }
    }
}