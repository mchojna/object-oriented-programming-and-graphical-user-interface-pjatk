public class RemoveException extends Exception{

    protected String targetGroup;

    public RemoveException(String targetGroup){
        this.targetGroup = targetGroup;
    }

    public String getMessage(){
        return "Nie ma możliwości usunięcia studenta z grupy (Grupa " + targetGroup + ") - nie należy do tej grupy";
    }
}
