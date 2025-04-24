public class TestFigur {
   
    public static void main(String[] args)
    {       
        Figura fig[] = new Figura[2];
        fig[0] = new Kolo(10, 10, 5);                           // położenie koła = srodek = (10,10), promień = 5
        fig[1] = new Prostokat(20, 20, 15, 10);      // położenie prostokąta = lewy górny wierzchołek = (20,20), szerokość = 15, wysokość = 10
      
        // polimorficzne wywołanie metody toString() z klas Kolo/Prostokat,
        // a nie z klasy Figura
        for (Figura f : fig)                // pętla for-each
            System.out.println(f);          // System.out.println(f.toString());
      
        fig[0].pozycja(12, 12);                    
        fig[1].pozycja(25, 30);

        System.out.println("\nPole " + fig[0].nazwa() + ": " + fig[0].pole());
        System.out.println("Obwod " + fig[0].nazwa() + ": " + fig[0].obwod() + "\n");

        System.out.println("Pole " + fig[1].nazwa() + ": " + fig[0].pole());
        System.out.println("Obwod " + fig[1].nazwa() + ": " + fig[0].obwod() + "\n");

        Figura p2 = new Prostokat2(20, 20, 10, 5, '*');

        ((Prostokat2)p2).rysuj();           

        // p2.rysuj() - nie dziala poniewaz interfejs Rysuj zostal zaimplementowany tylko do klasy Prostokat 2, a obiekt p2 jest typu Figura ktora nie ma metody rysuj
    
        Kolo2 k2 = new Kolo2(15, 20, 5);
            
        k2.przesunDo(50, 40);       // przesunięcie środka koła do punktu (50, 40)
        System.out.println(k2);
            
        k2.powrot();                    // powrót do poprzedniej pozycji (bezpośrednio przed przesunięciem) środka koła
        System.out.println(k2);
    
    }
}
