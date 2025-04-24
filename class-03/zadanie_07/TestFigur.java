public class TestFigur {
   
    public static void main(String[] args)
    {       
        Figura fig[] = new Figura[12];
        fig[0] = new Kolo(0, 0, 5);
        fig[1] = new Prostokat(0, 0, 25, 10);
        fig[2] = new Prostokat(0, 0, 6, 8);
        fig[3] = new Prostokat(0, 0, 5, 2);
        fig[4] = new Kolo(0, 0, 7);
        fig[5] = new Prostokat(0, 0, 15, 10);
        fig[6] = new Kolo(0, 0, 2);
        fig[7] = new Kolo(0, 0, 4);
        fig[8] = new Prostokat(0, 0, 5, 9);
        fig[9] = new Prostokat(0, 0, 1, 8);
        fig[10] = new Prostokat(0, 0, 1, 8);
        fig[11] = new Prostokat(0, 0, 1, 8);
        
        System.out.println("Przed sortowanie:\n");
        for (Figura f : fig)
            System.out.println(f);
      
        java.util.Arrays.sort(fig);

        System.out.println("Po sortowanie:\n");
        for (Figura f : fig)
            System.out.println(f);
    
    }
}
