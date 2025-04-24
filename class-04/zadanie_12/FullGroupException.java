public class FullGroupException extends Exception{

    protected String targetGroup;

    public FullGroupException(String targetGroup){
        this.targetGroup = targetGroup;
    }

    public String getMessage(){
        return "Nie ma możliwości przypisania studenta do grupy (Grupa " + this.targetGroup + ") - brak miejsca";
    }
}
