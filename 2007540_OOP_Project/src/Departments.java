import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


/**
 * CLASS REPRESENTING A UNIVERSITY DEPARTMENT
 */


public class Departments implements Departmentable {

    private String schoolName;

    private ArrayList<Student> students;

    private ArrayList<Staff> staff;
    private ArrayList<Courses> courses;

    public Departments(String name) {
        this.setSchoolName(name);
        this.setCourses(new ArrayList<>());
        this.setStaff(new ArrayList<>());
        this.setStudents(new ArrayList<>());
    }

    @Override
    public String getSchoolName() {
        return schoolName;
    }

    @Override
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public ArrayList<Staff> getStaff() {
        return staff;
    }

    @Override
    public void setStaff(ArrayList<Staff> staff) {
        this.staff = staff;
    }

    @Override
    public ArrayList<Courses> getCourses() {
        return courses;
    }

    @Override
    public void setCourses(ArrayList<Courses> courses) {
        this.courses = courses;
    }

    @Override
    public ArrayList<Modules> getDepartmentModules(){
        ArrayList<Modules> tempArr = new ArrayList<>();
        for (Courses temp : this.courses) {
            tempArr.addAll(temp.getcourseModules());
        }
        return tempArr;
    }

    /**
     *
     * @param rawStaff staff list
     *
     * ONLY DELEGATES STAFF WHEN THERE ARE ENOUGH STAFF TO COVER EACH MODULE!!!
     * OTHERWISE JUST ADDS ALL RELEVANT STAFF TO THE DEPARTMENT OBJECT
     */

    public void assignStaff(ArrayList<Staff> rawStaff) throws Exception {

        if (rawStaff.size() == 0){
            throw new Exception();
        }

        int staffModuleCounter = 0;
        int requiredModules = StructureValues.MODULECOUNT.getCount()*StructureValues.COURSECOUNT.getCount();

        for (Staff staffMember : rawStaff) {
            if (Objects.equals(staffMember.getDepartment(), this.schoolName)) {
                if (staffMember.getMaxModules() + staffModuleCounter <= requiredModules) {
                    this.getStaff().add(staffMember);
                    staffModuleCounter += staffMember.getMaxModules();
                }
                if (staffModuleCounter == requiredModules) {
                    return;
                }
            }
        }
    }

    /**
     * seeks to add all students in a department to a departments courses evenly. First of all works out how many students fit into a courses evenly, then works out
     * how many students are left. Then seeks to spread all students across all courses. Students course property is also set, so each student can see what modules they have.
     */


    public void addStudentsToCourses()throws Exception {

        if (this.getStudents().size() == 0 || this.getCourses().size() == 0) {
            System.out.println("NO STUDENTS INITIALIZED");
            throw new Exception();
        } else {

            int remainder = this.getStudents().size() % StructureValues.COURSECOUNT.getCount();
            int studentsPerCourse = (this.getStudents().size()-remainder) / StructureValues.COURSECOUNT.getCount();
            int index = 0;
            int endIndex = studentsPerCourse;

                for (Courses course : this.getCourses()) {

                    if (index == this.getStudents().size() - remainder) {
                        throw new Exception();
                    } else {
                        if (index != endIndex) {

                            while (index != endIndex) {
                                course.getCourseStudents().add(this.students.get(index));
                                this.students.get(index).setStudentCourse(course);
                                //Append all student indexs to course arrays
                                //Instatiate coruse property on student
                                if (remainder != 0) {
                                    course.getCourseStudents().add(this.students.get(this.getStudents().size()-remainder));
                                    this.students.get(this.getStudents().size()-remainder).setStudentCourse(course);
                                    //append end of array student to course
                                    remainder -= 1;
                                }
                                index++;
                            }

                        } else {

                            endIndex += studentsPerCourse;

                            while (index != endIndex) {
                                course.getCourseStudents().add(this.students.get(index));
                                this.students.get(index).setStudentCourse(course);
                                //Append all student indexs to course arrays
                                //Instatiate coruse property on student
                                if (remainder != 0) {
                                    course.getCourseStudents().add(this.students.get(this.getStudents().size()-remainder));
                                    this.students.get(this.getStudents().size()-remainder).setStudentCourse(course);
                                    //append end of array student to course
                                }
                                index++;
                            }
                        }
                    }
                }
        }
    }

    /**
     * <h1>ADDS TUTORS TO MODULES</h1>
     * <p>First check if tutors have been initialised, if so randomly choose department staff to append to each tutor to a module on each course</p>
     */
    public void addTutorsToModules()throws Exception{

        if (this.getStaff().size() == 0 || this.getCourses().size() == 0) {
            System.out.println("NO STAFF INITIALIZED");
            throw new Exception();
        } else {

            for (Courses course: this.getCourses()) {
                for (Modules module: course.getcourseModules()) {
                    Random generator = new Random();
                    int randomIndex = generator.nextInt(this.getStaff().size()-1);
                    module.setLecturer(this.getStaff().get(randomIndex));
                }
            }

        }
    }
    /**
     * <h1>ADDS STUDENTS TO MODULES</h1>
     * <p>First check if STUDENTS have been initialised, if so randomly choose department staff to append to each tutor to a module on each course</p>
     */
    public void addStudentsToModules()throws Exception{
        if (this.getStudents().size() == 0 || this.getCourses().size() == 0) {
            System.out.println("NO STUDENTS INITIALIZED");
            throw new Exception();
        } else {
            for (Courses course: this.getCourses()) {
                for (Modules module: course.getcourseModules()) {
                    module.setStudents(course.getCourseStudents());
                }
            }

        }

    }


    /***
     *
     * <h1>SET COURSE/MODULES</h1>
     * <p>Set courses and modules to each department randomly, with a length which is justified via "limit"</p>
     *
     * @param rawData raw list to randomly select from
     * @param modifiedProperty property of object to be appended to
     * @param limit how large you want array to be
     * @param <T> Generic type (of Arraylist)
     */

    public <T> void setCM(ArrayList<T> rawData, ArrayList<T> modifiedProperty, int limit) {
        for (int i = 0; i < limit; i++) {
            Random generator = new Random();
            int randomIndex = generator.nextInt(rawData.size());
            modifiedProperty.add(rawData.get(randomIndex));
            rawData.remove(randomIndex);
        }
    }



}
