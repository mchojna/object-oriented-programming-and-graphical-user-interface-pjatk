package ClassesPackage;

import java.util.ArrayList;
import java.util.List;

public class ListaZyczen extends Lista {

    public ListaZyczen(Klient klient) {
        super(klient);
    }

    public void zamien(Koszyk koszyk) {
        List<Samochod> listaSamochodowDoUsuniecia = new ArrayList<>();

        for(Samochod samochod: super.listaSamochodow){
            if(samochod.hasCena()){
                koszyk.dodajDoListy(samochod);
                listaSamochodowDoUsuniecia.add(samochod);
            }
        }

        for(Samochod samochod: listaSamochodowDoUsuniecia){
            super.listaSamochodow.remove(samochod);
        }
    }
}