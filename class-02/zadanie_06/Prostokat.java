public class Prostokat extends Figura{
    
    protected int szerokosc;
    protected int wysokosc;

    public Prostokat(int wspX, int wspY, int szerokosc, int wysokosc){
        super(wspX, wspY);
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }

    public String nazwa(){
        return "Prostokat";
    }

    @Override
    public void pozycja(int punktX, int punktY){
        
        if(((punktX >= super.wspX) && (punktX <= (super.wspX + szerokosc))) && ((punktY <= super.wspY) && (punktX >= (super.wspY - wysokosc)))){
            System.out.println("Punkt (" + punktX + ", " + punktY + ") znajduje sie wewnatrz prostokatu"); 
        }else{
            System.out.println("Punkt (" + punktX + ", " + punktY + ") znajduje sie na zewnatrz prostokatu");
        }
    };

    @Override
    public String toString(){
        return nazwa() + "\n" + 
        "Lewy gorny: (" + super.wspX + ", " + super.wspY + ")\n" +
        "Szerokosc: " + this.szerokosc + ", Wysokosc: " + this.wysokosc + "\n";
    }

    public double pole(){
        return this.wysokosc * this.szerokosc; 
    }

    public double obwod(){
        return 2 * this.wysokosc + 2 * this.szerokosc;
    }

}
