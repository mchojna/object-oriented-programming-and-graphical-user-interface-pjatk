package zadanie_16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public class Slowa implements Iterable<Map.Entry<String, Integer>>{

    protected Map<String, Integer> mapaSlow = new HashMap<String, Integer>();

    public Slowa(String nazwaPliku) throws IOException{
        Stream<String> linie = Files.lines(Paths.get(nazwaPliku));

        linie
            .flatMap(linia -> Stream.of(linia.split("[\\[\\]123 ;,-]+")))
            .map(linia -> linia.toUpperCase())
            .sorted(Comparator.comparing(linia -> linia))
            .forEach(this::policz);

        linie.close();
        }

    private void policz(String word) {
        mapaSlow.put(word, mapaSlow.getOrDefault(word, 0) + 1);
    }

    @Override
    public Iterator<Map.Entry<String, Integer>> iterator() {
        return mapaSlow.entrySet().iterator();
    }
}