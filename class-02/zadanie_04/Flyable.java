public interface Flyable{

    abstract String drive();

    abstract double distance();

    static Flyable hybrid(Flyable fly1, Flyable fly2){

        String hybridDrive = fly1.drive() + "-" + fly2.drive();

        double hybridDistance = fly1.distance() + fly2.distance();

        Flyable hybridFly = new Flyable(){

            protected String naped = hybridDrive;
            protected double odleglosc = hybridDistance;

            @Override
            public String drive(){
                return this.naped;
            }

            @Override
            public double distance(){
                return this.odleglosc;
            }
        };

        return hybridFly;
    }

    abstract String toString();

    public static String najkrotszy(Flyable[] flyables){

        double minOdlegosc = 123456789;
        int minIndex = 0;

        for(int i = 0; i < flyables.length; i++){
            if(flyables[i].distance() < minOdlegosc){
                minIndex = i;
                minOdlegosc = flyables[i].distance();
            }
        }

        return flyables[minIndex] + "";
    }
}