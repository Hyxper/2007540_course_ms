import java.io.IOException;
import java.util.ArrayList;


public class Init {

    public static void main(String[] args){


        try {
            ArrayList<Student> students = FileParser.FormatJson
                    ("2007540_OOP_Project/data/students.json", Student[].class);
            ArrayList<Staff> staffMembers = FileParser.FormatJson
                    ("2007540_OOP_Project/data/staff.json", Staff[].class);
            ArrayList<Modules> modules = FileParser.stripModules(FileParser.FormatJson
                    ("2007540_OOP_Project/data/modules.json", Modules[].class));
            ArrayList<Courses> courses = FileParser.FormatJson
                    ("2007540_OOP_Project/data/Courses.json",Courses[].class);

            String[] rawDepartments = FileParser.FormatCSV("2007540_OOP_Project/data/academic-depts.csv").toArray(new String[0]);

            //Multiton pattern to create my departments?


            //CREATE SUPER DUPER VARIABLES FOR COUNTERS
            //ADD @SERIALIZEDNAME TO ALL JSON PROPERTIES

            ArrayList<Departments> departments = new ArrayList<>();


            for (String specialism : rawDepartments) {
               Departments temp = new Departments(specialism);
               temp.setCM(courses,temp.courses,8);
                for (Courses course: temp.courses) {
                    temp.setCM(modules, course.getcourseModules(),12 );
                }
//
               departments.add(temp);
//               temp.setCM(modules,temp.courses.get)
            }

            System.out.println("!");

        }catch (IOException ex){
            System.out.println (ex.toString());
            System.out.println("A file could not be found");
            System.exit(0);
        }






    }

}
