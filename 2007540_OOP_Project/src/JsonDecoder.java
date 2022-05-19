import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonDecoder {

    public JsonDecoder() {

    }

    public static void Printer(String json){

        try {

            Reader reader = Files.newBufferedReader(Paths.get("src/"+json));

            List<Student> students = new Gson().fromJson(reader, new TypeToken<List<Student>>() {}.getType());

            System.out.println(students.get(1).getFirstName());

            reader.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}
