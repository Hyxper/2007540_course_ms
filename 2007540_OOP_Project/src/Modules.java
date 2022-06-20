import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


/**
 * CLASS THAT REPRESENTS A UNIVERSITY MODULE
 */
public class Modules implements Modulable {
    private String name;
    private String code;
    @SerializedName("ac_year")
    private String acYear;

    private ArrayList<Student> students;

    private Staff lecturer;

    @Override
    public String getModuleName() {
        return name;
    }

    @Override
    public void setModuleName(String name) {
        this.name = name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getAcYear() {
        return acYear;
    }

    @Override
    public void setAcYear(String acYear) {
        this.acYear = acYear;
    }

    @Override
    public Staff getLecturer() {
        return lecturer;
    }

    @Override
    public void setLecturer(Staff lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
