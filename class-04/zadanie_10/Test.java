import java.util.*;

public class Test {
   
    public static void main(String[] args) {
            
        // tworzenie listy osób
        List<Osoba> lista = Arrays.asList(
                                new Osoba("Anna", 23),
                                new Osoba("Maria", 22),
                                new Osoba("Anna", 20),
                                new Osoba("Wojciech", 21)
                            );
        // sortowanie według podanego komparatora (po imię)
        Collections.sort(lista, new KomparatorOsob(Kryterium.imie));
        System.out.println(lista);
        
        // sortowanie według podanego komparatora (po wieku)
        Collections.sort(lista, new KomparatorOsob(Kryterium.wiek));
        
        // lub zamiast komparatora "po wieku" napisać wyrażenie lambda w miejscu /* ... */

        // Collections.sort(lista, new KomparatorOsob(){
        //     public int compare(Osoba o1, Osoba o2){
        //         return o1.getImie().compareTo(o2.getImie());
        //     }
        // });
        // System.out.println(lista);

        Collections.sort(lista, 
            (o1, o2) -> {
                return o1.getWiek() - o2.getWiek();
            }
        );
        System.out.println(lista);
        
        // sortowanie według porządku naturalnego określonego w klasie Osoba
        Collections.sort(lista);
        System.out.println(lista);
    }
}
