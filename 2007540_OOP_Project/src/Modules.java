import java.util.ArrayList;

public class Modules {
    private String name;
    private String code;
    private String ac_year;

    private ArrayList<Student> students;

    private Staff lecturer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAc_year() {
        return ac_year;
    }

    public void setAc_year(String ac_year) {
        this.ac_year = ac_year;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Staff getLecturer() {
        return lecturer;
    }

    public void setLecturer(Staff lecturer) {
        this.lecturer = lecturer;
    }
}
