import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Departments implements Dependencies{

    private String schoolName;

    private ArrayList<Student> students;

    private ArrayList<Staff> staff;
    private ArrayList<Courses> courses;
    public Departments(String name){
        this.setSchoolName(name);
        this.setCourses(new ArrayList<>());
        this.setStaff(new ArrayList<>());
        this.setStudents(new ArrayList<>());
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
            if (student.getDepartment().equals(this.getSchoolName())) {

            }
        }


    }


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<Staff> staff) {
        this.staff = staff;
    }

    public ArrayList<Courses> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Courses> courses) {
        this.courses = courses;
    }

    public void assignStaff (ArrayList<Staff> rawStaff){

        int staffModuleCounter = 0;

        for (Staff staffMember : rawStaff) {
            if (Objects.equals(staffMember.getDepartment(), this.schoolName)) {
                if (staffMember.getMax_modules() + staffModuleCounter <= moduleCount) {
                    this.getStaff().add(staffMember);
                    staffModuleCounter += staffMember.getMax_modules();
                }
                if (staffModuleCounter == moduleCount) {
                    return;
                }
            }
        }
    }

    public void delegateStudents(){

        int studentsPerCourse = 0;

        if(this.getStudents().size() == 0 || this.getCourses().size() == 0){
            System.out.println("NO STUDENTS INITIALIZED");
        }else{

            if(this.getStudents().size() % 2 == 0){
                studentsPerCourse = this.getStudents().size()/moduleCount;
                int index = 0;
                int endIndex = studentsPerCourse-1;

                if (endIndex != this.getStudents().size()-1) {
                    for (Courses course : this.getCourses()) {
                        while (index <= endIndex) {
                            Student temp = this.students.get(index);
                            course.getCourseStudents().add(temp);
                            index++;
                        }
                        endIndex += studentsPerCourse;

                    }
                }
            }


        }
    }
}
