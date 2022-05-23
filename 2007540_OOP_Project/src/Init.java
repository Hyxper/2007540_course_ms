import java.io.IOException;
import java.util.ArrayList;


public class Init {

    public static void main(String[] args){


        //BLOCK HERE CREATES ALL ARRAYLISTS NEEDED FROM JSON FILES
        //      "data\\"+file not working????

        try {
            ArrayList<Student> students = JsonParse.FormatJson
                    ("C:\\2007540_course_ms\\2007540_OOP_Project\\data\\students.json", Student[].class);
            ArrayList<Staff> staffMembers = JsonParse.FormatJson
                    ("C:\\2007540_course_ms\\2007540_OOP_Project\\data\\staff.json", Staff[].class);
            ArrayList<Modules> modules = JsonParse.FormatJson
                    ("C:\\2007540_course_ms\\2007540_OOP_Project\\data\\modules.json", Modules[].class);

            for (Modules module : modules
            ) {
                System.out.println(module.getAc_year()+" "+module.getCode()+" "+module.getName());
            }

            for (Student student : students
            ) {
                System.out.println(student.getFirst_name()+" "+student.getLast_name()+" "
                        +student.getId()+" "+student.getType());
            }

            for (Staff staff : staffMembers
            ) {
                System.out.println(staff.getFirst_name()+" "+staff.getLast_name()+" "
                        +staff.getId()+" "+staff.getMax_modules());
            }

        }catch (IOException ex){
            System.out.println (ex.toString());
            System.out.println("A file could not be found");
            System.exit(0);
        }






    }

}
