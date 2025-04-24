package zadanie_14;

import java.util.*;

public class Test {
    public static void main(String[] args){
        String[] arr = {
            "salon A", "Mercedes", "130000",
            "salon B", "Mercedes", "120000",
            "salon C", "Ford", "110000",
            "salon B", "Opel", "90000",
            "salon C", "Honda", "95000",
            "salon A", "Ford", "105000",
            "salon A", "Renault", "75000"
        };
        
        Map<String, List<Samochod>> mapaSamochodow = new HashMap <String, List<Samochod>>();

        for(int i = 0; i < arr.length; i = i + 3){

            String klucz = arr[i];

            Samochod s = new Samochod(arr[i + 1], arr[i + 2]);

            List<Samochod> listaSamochodow = new ArrayList<Samochod>();

            if(!mapaSamochodow.containsKey(klucz)){

                listaSamochodow.add(s);

                mapaSamochodow.put(klucz, listaSamochodow);
            }else{

                listaSamochodow = mapaSamochodow.get(klucz);

                listaSamochodow.add(s);

                mapaSamochodow.put(klucz, listaSamochodow);
            }
        }

        System.out.println(mapaSamochodow);

        String najtanszySalon = "";
        String najtanczaMarka = "";
        int najnizszaCena = 1000000;

        for(String klucz: mapaSamochodow.keySet()){
            for(Samochod s: mapaSamochodow.get(klucz)){
                // System.out.println(klucz + " " + s);

                int aktualnaCena = Integer.valueOf(s.getCena());

                if(aktualnaCena < najnizszaCena){
                    najtanszySalon = klucz;
                    najtanczaMarka = s.getMarka();
                    najnizszaCena = aktualnaCena;
                }
            }
        }

        System.out.println(najtanszySalon + ", " + najtanczaMarka + ", " + najnizszaCena);

    }
}
