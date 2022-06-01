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


    /***
     *
     * @param rawData raw list to randomly select from
     * @param modifiedProperty property of object to be appended to
     * @param limit how large you want array to be
     * @param <T> Generic type (of Arraylist)
     */
    <T> void setCM (ArrayList<T> rawData, ArrayList<T> modifiedProperty, int limit){
        for (int i = 0; i < limit; i++) {
            Random generator = new Random();
            int randomIndex = generator.nextInt(rawData.size());
            modifiedProperty.add(rawData.get(randomIndex));
            rawData.remove(randomIndex);
        }
    }

    void AssignStudent(ArrayList<Student> students, int limit) {
        for (Student student : students) {
            if (student.getDepartment().equals(this.schoolName)) {

            }
        }


    }


}
