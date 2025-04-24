import java.util.ArrayList;
import java.util.List;

public class Group {
    
    protected String name;
    protected int capacity;
    protected int numOfStudents;

    protected List<Student> studentsList;

    public Group(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.numOfStudents = 0;

        this.studentsList = new ArrayList<Student>(capacity);
    }

    @Override
    public String toString(){
        return "Grupa " + this.name;
    }

    public String getName(){
        return this.name;
    }

    public void assign(Student s) throws FullGroupException, AlreadyAssignedException{

        if(this.capacity == this.numOfStudents){
            throw new FullGroupException(this.name);
        }else if(s.assignedToGroup()){
            throw new AlreadyAssignedException(this.name, s.groupName());
        }else{
            studentsList.add(s);
            numOfStudents++;
            s.add(this);
        }
    }

    public void remove(Student s) throws RemoveException{

        if(s.groupName() != this.name){
            throw new RemoveException(this.name);
        }else{
            studentsList.remove(s);
            numOfStudents--;
            s.remove();
        }
    }

    public Student[] getStudents(){
        Student[] studentsTab = new Student[numOfStudents];
        int index = 0;

        for(Student s: studentsList){
            studentsTab[index++] = s;
        }

        return studentsTab;
    }
}
