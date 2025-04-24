public class Kolo extends Figura{
    
    protected int promien;

    public Kolo(int wspX, int wspY, int promien){
        super(wspX, wspY);
        this.promien = promien;
    }

    public String nazwa(){
        return "Kolo";
    }

    @Override
    public void pozycja(int punktX, int punktY){
        
        if((Math.pow((punktX - super.wspX), 2) + Math.pow((punktY - super.wspY), 2)) <= (this.promien * this.promien)){
            System.out.println("Punkt (" + punktX + ", " + punktY + ") znajduje sie wewnatrz kola"); 
        }else{
            System.out.println("Punkt (" + punktX + ", " + punktY + ") znajduje sie na zewnatrz kola");
        }

    };

    @Override
    public String toString(){
        return nazwa() + "\n" + 
        "Srodek: (" + super.wspX + ", " + super.wspY + ")\n" +
        "Promien: " + this.promien;
    }

}
