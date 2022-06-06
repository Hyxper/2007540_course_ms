import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Courses {

    @SerializedName("course_name")
    private String courseName;
    @SerializedName("course_code")
    private String courseCode;

    private ArrayList<Modules> courseModules;

    private ArrayList<Student> courseStudents;


    public Courses() {
        this.courseModules = new ArrayList<>();
        this.courseStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public ArrayList<Modules> getcourseModules() {
        return courseModules;
    }

    public void setcourseModules(ArrayList<Modules> courseModules) {
        this.courseModules = courseModules;
    }

    public ArrayList<Student> getCourseStudents() {
        return courseStudents;
    }

    public void setCourseStudents(ArrayList<Student> courseStudents) {
        this.courseStudents = courseStudents;
    }

}
