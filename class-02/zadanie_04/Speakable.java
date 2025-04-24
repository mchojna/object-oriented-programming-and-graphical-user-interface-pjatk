interface Speakable {
    
    abstract String speak();

    public static String najglosniejszy(Speakable[] speakables){

        double maxGlosnosc = 0;
        int maxIndex = 0;

        for(int i = 0; i < speakables.length; i++){
            
            if(speakables[i].speak().length() > maxGlosnosc){

                maxGlosnosc = speakables[i].speak().length();
                maxIndex = i;
            }
        }

        return speakables[maxIndex].speak();
    }
}
