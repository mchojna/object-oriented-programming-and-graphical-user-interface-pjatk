package zadanie_13;

import java.util.Collection;

public class Osoba implements Comparable<Osoba>{

    public static boolean wKolekcji(Collection<Osoba> kol, String imie, int rokUrodzenia) {
        return kol.contains(new Osoba(imie, rokUrodzenia));
    }
    protected String imie;

    protected int rokUrodzenia;

    public Osoba(String imie, int rokUrodzenia){
        this.imie = imie;
        this.rokUrodzenia = rokUrodzenia;
    }

    public String getImie(){
        return this.imie;
    }

    public int getRokUrodzenia(){
        return this.rokUrodzenia;
    }

    @Override
	public boolean equals(Object obj){ // ArrayList
		
		if (this == obj) {
            return true;
        }
		
		if (obj == null || this.getClass() != obj.getClass()){
			return false;
        }
		
		Osoba o = (Osoba) obj;
		
		if(this.getImie() == o.getImie() && this.getRokUrodzenia() == o.getRokUrodzenia()){
            return true;
        }else{
            return false;
        }
	}

    @Override
    public int compareTo(Osoba o) { // TreeSet
        if(this.getImie() == o.getImie() && this.getRokUrodzenia() == o.getRokUrodzenia()){
            return 0;
        }else{
            return 1;
        }

    }

    @Override
    public int hashCode(){ // HashSet

        int code = 0;
        String name = this.getImie();

        code += this.getRokUrodzenia();

        for(int i = 0; i < name.length(); i++){
            code += (int) name.charAt(i);
        }

        return code;
    }
    

}