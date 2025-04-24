package ClassesPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Lista implements Iterable<Samochod> {

    protected List<Samochod> listaSamochodow;
    protected Klient klient;

    public Lista(Klient klient) {
        this.listaSamochodow = new ArrayList<>();
        this.klient = klient;
    }

    public void dodajDoListy(Samochod samochod){
        listaSamochodow.add(samochod);
    }

    @Override
    public String toString(){
        if(!this.listaSamochodow.isEmpty()){
            String zawartoscListy = klient.getIdentyfikator() + ":\n";

            for(Samochod samochod: listaSamochodow){
                zawartoscListy = zawartoscListy.concat(samochod.toString() + "\n");
            }

            return zawartoscListy;
        }else{
            return klient.getIdentyfikator() + ": -- pusto\n";
        }
    }

    public void wyczyscListe(){
        this.listaSamochodow.clear();
    }

    @Override
    public Iterator<Samochod> iterator() {
        return new Iterator<>() {

            int aktualnyElement = 0;

            @Override
            public boolean hasNext() {
                return aktualnyElement < listaSamochodow.size();
            }

            @Override
            public Samochod next() {
                return listaSamochodow.get(aktualnyElement++);
            }
        };
    }
}
