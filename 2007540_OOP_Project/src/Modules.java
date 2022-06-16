import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Modules {
    private String name;
    private String code;
    @SerializedName("ac_year")
    private String acYear;

    private ArrayList<Student> students;

    private Staff lecturer;

    public String getModuleName() {
        return name;
    }

    public void setModuleName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAcYear() {
        return acYear;
    }

    public void setAcYear(String acYear) {
        this.acYear = acYear;
    }
//
//    public ArrayList<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(ArrayList<Student> students) {
//        this.students = students;
//    }

    public Staff getLecturer() {
        return lecturer;
    }

    public void setLecturer(Staff lecturer) {
        this.lecturer = lecturer;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
