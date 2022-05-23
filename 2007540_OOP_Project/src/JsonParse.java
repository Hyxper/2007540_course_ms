import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import static java.util.List.of;

public class JsonParse <T> {



    public JsonParse() {

    }

    public ArrayList<T> Printer(String file) throws IOException {



        //create gson object
        Gson gson = new Gson();

        //read file stream
        FileReader reader = new FileReader("data\\" + file);

        //read encoded value as JSON tokens
        JsonReader jsonReader = new JsonReader(reader);


        //create an array of Student from JSON file, casting each student to a java object of Student
        T[] userArray = gson.fromJson(jsonReader, User[].class);
        /**
         * ITS HERE HOW CAN I TELL PRINTER WHAT TYPE i WANT MY ARRAY TO BE!!!
         */

        //create arraylist of users from Student array

        return new ArrayList<>(of(userArray));

    }
}