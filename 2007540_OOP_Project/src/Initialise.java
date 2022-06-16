import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Initialise {

    /**
     *
     * @return returns an array of fully fleshed out departments ready to be used.
     */


    public static ArrayList<Departments> InitialiseDepartments() {



        try {

            //DECODE ALL JSON, AND CSV FILES INTO ARRAYS TO BE USED (USING ENUMS IN "FILE EXTENSION" TO DIRECT METHOD).

            ArrayList<Student> students = FileParser.FormatJson(FileExtensions.FILEPATH.getExtension()+FileExtensions.STUDENTS.getExtension(), Student[].class);

            ArrayList<Staff> staffMembers = FileParser.FormatJson(FileExtensions.FILEPATH.getExtension()+FileExtensions.STAFF.getExtension(), Staff[].class);

            ArrayList<Modules> modules = FileParser.stripModules(FileParser.FormatJson(FileExtensions.FILEPATH.getExtension()+FileExtensions.MODULES.getExtension(), Modules[].class));

            ArrayList<Courses> courses = FileParser.FormatJson(FileExtensions.FILEPATH.getExtension()+FileExtensions.COURSES.getExtension(), Courses[].class);

            String[] rawDepartments = FileParser.FormatCSV(FileExtensions.FILEPATH.getExtension()+FileExtensions.DEPARTMENTS.getExtension()).toArray(new String[0]);



            File logFile = FileParser.createFile(FileExtensions.FILEPATH.getExtension(), FileExtensions.LOGFILE.getExtension());
            ArrayList<Departments> departments = new ArrayList<>();

            for (String specialism : rawDepartments) {

                //create new department
                Departments temp = new Departments(specialism);

                //ADD HEADING TO LOG FILE FOR EACH DEPARTMENT
                if (logFile != null) {
                    FileParser.writeToFile(logFile,FileExtensions.SPLITERATOR.getExtension());
                    FileParser.writeToFile(logFile,temp.getSchoolName());
                    FileParser.writeToFile(logFile,FileExtensions.SPLITERATOR.getExtension());
                }

                //randomly select courses to add to department (max number set in dependencies interface)
                temp.setCM(courses, temp.getCourses(), StructureValues.COURSECOUNT.getCount());


                //ADD MODULES TO EACH COURSE RANDOMLY
                for (Courses course : temp.getCourses()) {
                    temp.setCM(modules, course.getcourseModules(), StructureValues.MODULECOUNT.getCount());
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


                //ADD ALL MEMBERS OF DEPARTMENT TO LOG FILE
                if(logFile != null){
                    for (Courses course: temp.getCourses()) {
                        FileParser.writeToFile(logFile,"COURSE: "+course.getCourseName());
                    }
                    FileParser.writeToFile(logFile,FileExtensions.SPLITERATOR.getExtension());
                    for (Modules module: temp.getDepartmentModules()) {
                        FileParser.writeToFile(logFile,"MODULE: "+module.getModuleName());
                    }
                    FileParser.writeToFile(logFile,FileExtensions.SPLITERATOR.getExtension());
                    for (Student activeStudent: temp.getStudents()) {
                        FileParser.writeToFile(logFile,"STUDENT: "+activeStudent.getFullName());
                    }
                    FileParser.writeToFile(logFile,FileExtensions.SPLITERATOR.getExtension());
                    for (Staff staffMember: temp.getStaff()) {
                        FileParser.writeToFile(logFile,"STAFF: "+staffMember.getFullName());
                    }
                }

            }

            return departments;

        } catch (IOException ex) {
            System.out.println("A file could not be found");
            return null;
        }
    }
}
