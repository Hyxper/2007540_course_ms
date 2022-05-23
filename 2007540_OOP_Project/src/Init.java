import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Init {

    public static void main(String[] args) throws IOException {

        JsonParse parser = new JsonParse<Student>();

        ArrayList<Student> students = parser.Printer("students.json");


        System.out.println(students.get(0)..toString());

//        for (Student student : students
//             ) {
//            System.out.println(student.getFirst_name()+" "+student.getLast_name()+" "
//            +student.getId()+" "+student.getClass());
//        }

//        List<User> staffMembers = JsonParse.Printer("staff.json");
//
//        for (User staff : staffMembers
//        ) {
//            System.out.println(staff.getFirst_name()+" "+staff.getLast_name()+" "
//                    +staff.getId()+" "+staff.getClass());
//        }
//
//        UserPrinter<Student> test = new UserPrinter<>();







    }

}
