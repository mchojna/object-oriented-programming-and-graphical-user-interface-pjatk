public abstract class Spiewak{

    public static int numerOgolny = 1;

    protected String nazwisko;
    protected int numer;

    public Spiewak(String nazwisko){
        this.nazwisko = nazwisko;
        this.numer = numerOgolny++;
    }

    public abstract String spiewaj();
    
    public String toString(){
        return "(" + this.numer + ") " + this.nazwisko + ": " + spiewaj();
    }

    public static String najglosniej(Spiewak[] spiewacy){

        int najglosniejszy = 0;
        int najglosniejszyIndex = 0;

        for(int i = 0; i < spiewacy.length; i++){

            int aktualnaNajwiekszaLiczba = 0;
            int aktualnaNajwiekszaLitera = 0;

            for(char c: spiewacy[i].spiewaj().toCharArray()){

                if(Character.isDigit(c)){
                    if((int)(c) > aktualnaNajwiekszaLiczba){
                        aktualnaNajwiekszaLiczba = (int)(c);
                    }
                }else if(Character.isLetter(c)){
                    if((int)(c) > aktualnaNajwiekszaLitera){
                        aktualnaNajwiekszaLitera = (int)(c);
                    }
                }

            }
            
            int aktualnyNajglosniejszy = aktualnaNajwiekszaLiczba + aktualnaNajwiekszaLitera;

            if(najglosniejszy < aktualnyNajglosniejszy){
                najglosniejszyIndex = i;
                najglosniejszy = aktualnyNajglosniejszy;
            }
        }


        return "" + spiewacy[najglosniejszyIndex];
    }
}