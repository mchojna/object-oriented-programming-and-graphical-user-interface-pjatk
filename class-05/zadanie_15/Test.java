package zadanie_15;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test{
    public static void main(String[] args) throws IOException{
        String nazwaPliky = "/Users/mchojna/Documents/University - PJAIT/Programowanie Obiektowe i GUI - Ćwiczenia/GUI_C05/zadanie_15/text.txt";

        Stream<String> linie1 = Files.lines(Paths.get(nazwaPliky), StandardCharsets.UTF_8);
        linie1.forEach(System.out::println);
        System.out.println();
        linie1.close();

        // Wyświetlić liczbę studentów z wynikiem co najmniej 50
        Stream<String> linie2 = Files.lines(Paths.get(nazwaPliky), StandardCharsets.UTF_8);
        long liczba = linie2
            .map(slowa -> slowa.split(" +"))
            .filter(slowa -> Integer.parseInt(slowa[2]) > 50)
            .count();
        System.out.println(liczba);
        System.out.println();
        linie2.close();
        
        // Wyświetlić studentów z wynikiem co najmniej 50, posortowanych według numeru grupy, a dla tej samej grupy według wyniku
        Stream<String> linie3 = Files.lines(Paths.get(nazwaPliky), StandardCharsets.UTF_8);
        linie3
            .map(slowa -> slowa.split(" +"))
            .filter(slowa -> Integer.parseInt(slowa[2]) >= 50)
            .sorted(Comparator.comparing(slowa -> Integer.parseInt(slowa[2])))
            .sorted(Comparator.comparing(slowa -> slowa[1]))
            .forEach(slowa -> System.out.println(slowa[0] + " " + slowa[1] + " " + slowa[2]));
        System.out.println();
        linie3.close();

        // Utwórz mapę, której kluczem jest numer grupy a wartością jest lista studentów tej grupy. Wydrukować utworzoną mapę
        Stream<String> linie4 = Files.lines(Paths.get(nazwaPliky), StandardCharsets.UTF_8);

        Map <String, List<Student>> mapaStudentow = linie4
            .map(slowa -> slowa.split(" +"))
            .map(slowa -> new Student(slowa[0], slowa[1], slowa[2]))
            .collect(Collectors.groupingBy(Student::getGrupa));
        linie4.close();

        for(String s: mapaStudentow.keySet()){
            System.out.println("Grupa " + s + " = " + mapaStudentow.get(s));
        }
    }
}