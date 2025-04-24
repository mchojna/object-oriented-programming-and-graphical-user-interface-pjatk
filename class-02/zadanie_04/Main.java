public class Main {
    public static void main(String[] args){
        
        Flyable b1 = new Bird();
        Flyable p1 = new Plane();
        Flyable v1 = new Virus();
        Flyable u1 = new Virus();

        
        Flyable hel1 = new Flyable() {
            
            protected String naped = "smiglo";
            protected double odleglosc = 50;
            
            @Override
            public String drive(){
                return this.naped;
            }
            
            @Override
            public double distance(){
                return this.odleglosc;
            }
            
            @Override
            public String toString(){
                return "naped: " + this.naped + "\todleglosc: " + this.odleglosc;
            }
            
        };
        
        Flyable h1 = Flyable.hybrid(p1, u1);
        
        Flyable[] flyArr = {b1, p1, v1, u1, h1, hel1};

        System.out.println(Flyable.najkrotszy(flyArr));

        Speakable s1 = new Speakable(){

            public String speak(){
                return "pi pi pi";
            }
        };

        Speakable s2 = new Speakable(){

            public String speak(){
                return "kukurykuuu";
            }
        };

        Speakable s3 = () -> {
                return "aj aj aj aj";
        };

        Speakable[] speakArr = {s1, s2, s3};

        System.out.println(Speakable.najglosniejszy(speakArr));
    }
}
