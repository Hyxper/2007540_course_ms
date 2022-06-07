import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static java.lang.Math.floor;

public class Departments implements Dependencies {

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

    /**
     *
     * @param rawStaff staff list
     * ONLY DELEGATES STAFF WHEN THERE ARE ENOUGH STAFF TO COVER EACH MODULE!!!
     * OTHERWISE JUST ADDS ALL RELEVANT STAFF TO THE DEPARTMENT OBJECT
     */

    public void assignStaff(ArrayList<Staff> rawStaff) {

        int staffModuleCounter = 0;
        int requiredModules = moduleCount*courseCount;

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


    public void addStudentsToCourses() {

        if (this.getStudents().size() == 0 || this.getCourses().size() == 0) {
            System.out.println("NO STUDENTS INITIALIZED");
        } else {

            int remainder = this.getStudents().size() % courseCount;
            int studentsPerCourse = (this.getStudents().size()-remainder) / courseCount;
            int index = 0;
            int endIndex = studentsPerCourse;

                for (Courses course : this.getCourses()) {

                    if (index == this.getStudents().size() - remainder) {
                        System.out.println("THROW ERROR");
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
     *
     */
    public void addTutorsToModules(){
        System.out.println(this.staff);
    }
    /***
     *
     * @param rawData raw list to randomly select from
     * @param modifiedProperty property of object to be appended to
     * @param limit how large you want array to be
     * @param <T> Generic type (of Arraylist)
     */
    <T> void setCM(ArrayList<T> rawData, ArrayList<T> modifiedProperty, int limit) {
        for (int i = 0; i < limit; i++) {
            Random generator = new Random();
            int randomIndex = generator.nextInt(rawData.size());
            modifiedProperty.add(rawData.get(randomIndex));
            rawData.remove(randomIndex);
        }
    }








}
