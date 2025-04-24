public abstract class Spiewak implements java.lang.Comparable<Spiewak>{

    private static int numerOgolny = 1;

    protected String nazwisko;
    protected int numer;

    public Spiewak(String nazwisko){
        this.nazwisko = nazwisko;
        this.numer = numerOgolny++;
    }

    public String getNazwisko(){
        return this.nazwisko;
    }

    public int getNumer(){
        return this.numer;
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

    public int compareTo(Spiewak s){
        
        if(this.spiewaj().length() == s.spiewaj().length()){
            if(this.getNazwisko().compareTo(s.getNazwisko()) == 0){
                return -1*(this.getNumer() - s.getNumer());
            }else{
                return -this.getNazwisko().compareTo(s.getNazwisko());
            }
        }else{
            return this.spiewaj().length() - s.spiewaj().length();
        }
    }
}