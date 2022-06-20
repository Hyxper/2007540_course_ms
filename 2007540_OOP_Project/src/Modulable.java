import java.util.ArrayList;


/**
//THIS INTERFACE IS USED TO ENSURE THAT ALL REQUIRED GETTERS AND SETTERS
// ARE IN PLACE FOR THE MODULE CLASS.
 **/
public interface Modulable {
    String getModuleName();

    void setModuleName(String name);

    String getCode();

    void setCode(String code);

    String getAcYear();

    void setAcYear(String acYear);

    Staff getLecturer();

    void setLecturer(Staff lecturer);

    ArrayList<Student> getStudents();

    void setStudents(ArrayList<Student> students);
}
