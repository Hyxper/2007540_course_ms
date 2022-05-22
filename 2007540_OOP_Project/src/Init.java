import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Init {

    public static void main(String[] args) throws IOException {

//https://stackoverflow.com/questions/42299871/how-generic-method-in-java-interface-convert-super-object-to-concrete-subclass-o

        Gson gson = new Gson();

        FileReader reader = new FileReader("C:\\2007540_course_ms\\2007540_OOP_Project\\data\\staff.json");
        JsonReader jsonReader = new JsonReader(reader);

        Student[] users = gson.fromJson(jsonReader, Student[].class);

        List<User> userList = new ArrayList<User>(Arrays.asList(users));


        for (User user : userList
             ) {
            System.out.println(user.getEmail());
        }
    }

}
