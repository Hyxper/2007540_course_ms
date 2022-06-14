import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Initialise implements Dependencies {

    /**
     *
     * @return returns an array of fully fleshed out departments ready to be used.
     */


    public static ArrayList<Departments> InitialiseDepartments() {

        try {

            //DECODE ALL JSON, AND CSV FILES INTO ARRAYS TO BE USED

            ArrayList<Student> students = FileParser.FormatJson
                    ("2007540_OOP_Project/data/students.json", Student[].class);
            ArrayList<Staff> staffMembers = FileParser.FormatJson
                    ("2007540_OOP_Project/data/staff.json", Staff[].class);
            ArrayList<Modules> modules = FileParser.stripModules(FileParser.FormatJson
                    ("2007540_OOP_Project/data/modules.json", Modules[].class));
            ArrayList<Courses> courses = FileParser.FormatJson
                    ("2007540_OOP_Project/data/Courses.json", Courses[].class);

            String[] rawDepartments = FileParser.FormatCSV("2007540_OOP_Project/data/academic-depts.csv").toArray(new String[0]);


            ArrayList<Departments> departments = new ArrayList<>();

            for (String specialism : rawDepartments) {

                //create new department
                Departments temp = new Departments(specialism);

                //randomly select courses to add to department (max number set in dependencies interface)
                temp.setCM(courses, temp.getCourses(), courseCount);

                //ADD MODULES TO EACH COURSE RANDOMLY
                for (Courses course : temp.getCourses()) {
                    temp.setCM(modules, course.getcourseModules(), moduleCount);
                }

                //ADD STUDENTS TO EACH DEPARTMENT
                for (Student student : students) {
                    if (Objects.equals(student.getDepartment(), temp.getSchoolName())) {
                        temp.getStudents().add(student);
                    }
                }

                //FOLLOWING ASSING STAFF TO DEPARTMENTS, STUDENTS TO COURSES, AND STUDENTS AND STAFF TO MODULES
                temp.assignStaff(staffMembers);

                temp.addStudentsToCourses();

                temp.addTutorsToModules();

                temp.addStudentsToModules();

                departments.add(temp);
//               temp.setCM(modules,temp.courses.get)
            }

            return departments;

        } catch (IOException ex) {
            System.out.println("A file could not be found");
            return null;
        }
    }
}
