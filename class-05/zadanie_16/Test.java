package zadanie_16;

import java.io.IOException;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws IOException {
               
        String file = "/Users/mchojna/Documents/University - PJAIT/Programowanie Obiektowe i GUI - Ćwiczenia/GUI_C05/zadanie_16/slowa.txt";
        for (Map.Entry<String, Integer> e : new Slowa(file))
            System.out.println(
                e.getKey() + " -> " + e.getValue());  
    }

}