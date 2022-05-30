import java.io.IOException;
import java.util.ArrayList;


public class Init {

    public static void main(String[] args){


        //BLOCK HERE CREATES ALL ARRAYLISTS NEEDED FROM JSON FILES
        //      "data\\"+file not working????

        try {
            ArrayList<Student> students = FileParser.FormatJson
                    ("H:\\2007540_course_ms\\2007540_OOP_Project\\data\\students.json", Student[].class);
            ArrayList<Staff> staffMembers = FileParser.FormatJson
                    ("H:\\2007540_course_ms\\2007540_OOP_Project\\data\\staff.json", Staff[].class);
            ArrayList<Modules> modules = FileParser.FormatJson
                    ("H:\\2007540_course_ms\\2007540_OOP_Project\\data\\modules.json", Modules[].class);
            ArrayList<Courses> courses = FileParser.FormatJson
                    ("H:\\2007540_course_ms\\2007540_OOP_Project\\data\\Courses.json",Courses[].class);


            String[] rawDepartments = FileParser.FormatCSV("H:\\\\2007540_course_ms\\\\2007540_OOP_Project\\\\data\\\\academic-depts.csv").toArray(new String[0]);

            //Multiton pattern to create my departments?

            ArrayList<Departments> departments = new ArrayList<>();
            for (String specialism : rawDepartments) {
               Departments temp = new Departments(specialism);
               departments.add(temp);
               temp.setCourses(courses);

            }

            System.out.println("!");

        }catch (IOException ex){
            System.out.println (ex.toString());
            System.out.println("A file could not be found");
            System.exit(0);
        }






    }

}
