import java.util.ArrayList;
//THIS INTERFACE IS USED TO ENSURE THAT ALL REQUIRED GETTERS AND SETTERS
// ARE IN PLACE FOR THE DEPARTMENT CLASS.

public interface Departmentable {
    String getSchoolName();

    void setSchoolName(String schoolName);

    ArrayList<Student> getStudents();

    void setStudents(ArrayList<Student> students);

    ArrayList<Staff> getStaff();

    void setStaff(ArrayList<Staff> staff);

    ArrayList<Courses> getCourses();

    void setCourses(ArrayList<Courses> courses);

    ArrayList<Modules> getDepartmentModules();


}
