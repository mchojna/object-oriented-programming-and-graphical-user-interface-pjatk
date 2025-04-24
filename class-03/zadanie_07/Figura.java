public abstract class Figura implements Obliczenie, java.lang.Comparable<Figura>{

    protected int wspX;
    protected int wspY;
    
    private static int indexGlobalny = 0;
    protected int index;

    public Figura(int wspX, int wspY){
        this.wspX = wspX;
        this.wspY = wspY;
        this.index = indexGlobalny++;
    }

    abstract String nazwa();

    abstract void pozycja(int punktX, int punktY);

    public int getIndex(){
        return this.index;
    }

    @Override
    public String toString(){
        return "";
    }


    @Override
    public int compareTo(Figura f){
        if(this.pole() == f.pole()){
            if(this.obwod() == f.obwod()){
                return this.getIndex() - f.getIndex();
            }else{
                return (int)(this.obwod() - f.obwod());
            }
        }else{
            return (int)(this.pole() - f.pole());
        }
    }

}