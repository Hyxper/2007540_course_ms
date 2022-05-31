import java.util.ArrayList;

public class Courses {

    private String course_name;
    private String course_code;

    private ArrayList<Modules> courseModules;


    public Courses(){
        this.courseModules = new ArrayList<>();
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public ArrayList<Modules> getcourseModules() {
        return courseModules;
    }

    public void setcourseModules(ArrayList<Modules> courseModules) {
        this.courseModules = courseModules;
    }
}
