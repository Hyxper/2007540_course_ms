import java.util.ArrayList;

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
