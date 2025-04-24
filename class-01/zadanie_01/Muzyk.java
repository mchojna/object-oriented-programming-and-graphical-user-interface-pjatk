public abstract class Muzyk{

    protected String imie;
    protected double czas;
    protected double stawka;
    protected String instrument;

    public Muzyk(String imie, double czas){
        this.imie = imie;
        this.czas = czas;
    }

    public abstract String imie();

    public abstract double czas();

    public abstract double stawka();

    public abstract String instrument();

    public static String maxHonorarium(Muzyk[] muzycy){

       int maxHonorariumIndex = 0;

        for(int i = 0; i < muzycy.length; i++){

            double aktualneHonorarium = muzycy[i].czas() * muzycy[i].stawka();
            double maxHonorarium = muzycy[maxHonorariumIndex].czas() * muzycy[maxHonorariumIndex].stawka();

            if(aktualneHonorarium > maxHonorarium){
                maxHonorariumIndex = i;
            }
        }

        return muzycy[maxHonorariumIndex].imie() + ", czas = " + muzycy[maxHonorariumIndex].czas() + " godz., stawka: " + muzycy[maxHonorariumIndex].stawka();
    }

}