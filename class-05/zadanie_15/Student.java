package zadanie_15;

public class Student {
    
    protected String imie;
    protected String grupa;
    protected String wynik;

    public Student(String imie, String grupa, String wynik){
        this.imie = imie;
        this.grupa = grupa;
        this.wynik = wynik;
    }

    public String getImie(){
        return this.imie;
    }

    public String getGrupa(){
        return this.grupa;
    }

    public String getWynik(){
        return this.wynik;
    }

    public String toString(){
        return this.imie + "(" + this.grupa + ")-" + this.wynik;
    }
}
