import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Courses implements Coursable {

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

    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public ArrayList<Modules> getcourseModules() {
        return courseModules;
    }

    @Override
    public void setcourseModules(ArrayList<Modules> courseModules) {
        this.courseModules = courseModules;
    }

    @Override
    public ArrayList<Student> getCourseStudents() {
        return courseStudents;
    }

    @Override
    public void setCourseStudents(ArrayList<Student> courseStudents) {
        this.courseStudents = courseStudents;
    }

}
