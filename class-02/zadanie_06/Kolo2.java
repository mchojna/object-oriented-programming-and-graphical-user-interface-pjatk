public class Kolo2 extends Kolo implements Transformacja{

    protected int pierwotneX;
    protected int pierwotneY;

    public Kolo2(int wspX, int wspY, int promien) {
        super(wspX, wspY, promien);
    }

    @Override
    public void przesunDo(int x, int y) {

        this.pierwotneX = super.wspX;
        this.pierwotneY = super.wspY;

        super.wspX = x;
        super.wspY = y;

    }

    @Override
    public void powrot() {
        
        super.wspX = this.pierwotneX;
        super.wspY = this.pierwotneY;
    }
    
}
