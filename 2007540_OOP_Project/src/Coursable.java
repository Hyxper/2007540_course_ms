import java.util.ArrayList;
//THIS INTERFACE IS USED TO ENSURE THAT ALL REQUIRED GETTERS AND SETTERS
// ARE IN PLACE FOR THE COURSE CLASS.
public interface Coursable {
    String getCourseName();

    void setCourseName(String courseName);

    String getCourseCode();

    void setCourseCode(String courseCode);

    ArrayList<Modules> getcourseModules();

    void setcourseModules(ArrayList<Modules> courseModules);

    ArrayList<Student> getCourseStudents();

    void setCourseStudents(ArrayList<Student> courseStudents);
}
