import java.util.ArrayList;
import java.util.Random;

public class Departments {

    String schoolName;

    ArrayList<Student> students;
    ArrayList<Modules> modules;
    ArrayList<Staff> staff;
    ArrayList<Courses> courses;
    public Departments(String name){
        this.schoolName = name;
        this.courses = new ArrayList<>();
        this.modules = new ArrayList<>();
        this.staff  = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    void setCourses (ArrayList<Courses> rawCourses){

        int coursesPer = 8;
        for (int i = 0; i < coursesPer; i++) {
            Random generator = new Random();
            int randomIndex = generator.nextInt(rawCourses.size());
            courses.add(rawCourses.get(randomIndex));
            rawCourses.remove(randomIndex);
        }
    }

}
