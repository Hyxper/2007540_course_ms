import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/***
 * <h1>CLASS JSON PARSE</h1>
 * <p>This parser class allows the user to pass in a string to a file address of a JSON file,
 * and also the class type. The generic method ".FormatJson" will return an arraylist of the passed type.</p>
 */
public class FileParser {

    /***
     * <h1>METHOD FORMATJSON</h1>
     * <p>CREATES A ARRAYLIST FROM A PASSED JSON FILE AND OBJECT TOKEN.</p>
     */
    public static <T> ArrayList<T> FormatJson(String file, Type classObj) throws IOException {

        //create gson object
        Gson gson = new Gson();

        //read file stream
        FileReader reader = new FileReader(file);

        //read encoded value as JSON tokens
        JsonReader jsonReader = new JsonReader(reader);


        //create an array of Student from JSON file, casting each student to a java object of Student
//        Type token = new TypeToken<ArrayList<T>>(){}.getType();
        T[] userArray = gson.fromJson(jsonReader, classObj);


        //create arraylist of users from Student array

        return new ArrayList<>(Arrays.asList(userArray));
    }
    /***
     * <h1>METHOD FORMATCSV</h1>
     * <p>RETURNS AN ARRAYLIST OF VALUES FROM A PASSED CSV</p>
     */
    public static ArrayList<String> FormatCSV(String file) throws IOException {

        String delimiter = ",";
        String line;
        ArrayList<List<String>> lines = new ArrayList<>();
        ArrayList<String> returnArr = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null) {
                List<String> values = Arrays.asList(line.split(delimiter));
                lines.add(values);
            }
            for (List<String> linesInFile : lines) {
                returnArr.addAll(linesInFile);
            }

            return returnArr;

        }

}
