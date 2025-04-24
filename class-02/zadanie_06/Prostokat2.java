public class Prostokat2 extends Prostokat implements Rysowanie{

    protected char znak;

    public Prostokat2(int wspX, int wspY, int szerokosc, int wysokosc, char znak) {
        super(wspX, wspY, szerokosc, wysokosc);
        this.znak = znak;

        // rysuj();
    }

    public void rysuj(){

        for(int i = 0; i < wysokosc; i++){
            for(int j = 0; j < szerokosc; j++){
                System.out.print(this.znak);
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
