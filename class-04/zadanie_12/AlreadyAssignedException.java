public class AlreadyAssignedException extends Exception{

    protected String targetGroup;
    protected String initialGroup;

    public AlreadyAssignedException(String targetGroup, String initialGroup){
        this.targetGroup = targetGroup;
        this.initialGroup = initialGroup;
    }

    public String getMessage(){
        return "Nie ma możliwości przypisania studenta do grupy (" + targetGroup + ") - już jest przypisany do grupy (Grupa " + initialGroup + ")";
    }
}
