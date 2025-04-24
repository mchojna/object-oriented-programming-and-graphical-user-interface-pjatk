public class Student {
    
    protected String surname;
    protected String name;
    protected int birthYear;
    protected int index;

    protected static int globalIndex = 1;

    protected Group group;

    public Student(String surname, String name, int birthYear){
        this.surname = surname;
        this.name = name;
        this.birthYear = birthYear;

        this.index = globalIndex++;

        this.group = null;
    }

    @Override
    public String toString(){
        return "(" + this.index + ") " + this.name + " " + this.surname + ", " + this.birthYear;
    }

    public boolean assignedToGroup(){
        return group != null;
    }

    public String groupName(){
        if(this.assignedToGroup()){
            return this.group.getName();
        }else{
            return null;
        }
    }

    public void add(Group group){
        this.group = group;
    }

    public void remove(){
        this.group = null;
    }
}
