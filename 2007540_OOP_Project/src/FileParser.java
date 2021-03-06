import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


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

        if (Objects.equals(file, "")){
            throw new IOException();
        }

        //create gson object
        Gson gson = new Gson();

        //read file stream
        FileReader reader = new FileReader(file);

        //read encoded value as JSON tokens
        JsonReader jsonReader = new JsonReader(reader);

        //create an array of Student from JSON file, casting each student to a java object of Student
//        Type token = new TypeToken<ArrayList<T>>(){}.getType();
        T[] userArray = gson.fromJson(reader, classObj);


        //create arraylist of users from Student array

        return new ArrayList<>(Arrays.asList(userArray));
    }
    /***
     * <h1>METHOD FORMATCSV</h1>
     * <p>RETURNS AN ARRAYLIST OF VALUES FROM A PASSED CSV</p>
     */
    public static ArrayList<String> FormatCSV(String file) throws IOException {

        if (Objects.equals(file, "")){
            throw new IOException();
        }

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

    /**
     *
     * @param rawModules modules being passed
     * @return RETURNS MODULE LIST BACK TO CALL, IN WHICH IT HAS REMOVED DUPLICATES
     */

    public static ArrayList<Modules> stripModules(ArrayList<Modules> rawModules)throws IOException{

        if (rawModules.size()==0){
            throw new IOException();
        }

            List<String> tempArr = null;
            ArrayList<Modules> returnModules = new ArrayList<>();

            rawModules.removeIf(module -> !Objects.equals(module.getAcYear(), "20"));

           //REMOVE DUPLICATE NAMES


            return rawModules;
        }


    /**
     *
     * @param filePath directory to write to
     * @param fileName name for file
     * @return FILE
     *
     * STATIC METHOD THAT CREATES A FILE, PROVIDING A FILEPATH TO CREATE TO, AND A FILE NAME HAVE BEEN PASSED
     */

    public static File createFile (String filePath, String fileName) throws IOException {

        if (Objects.equals(filePath, "")||Objects.equals(fileName, "")){
            throw new IOException();
        }

            try {

                File fileToPrint = new File(filePath+fileName);

                if (fileToPrint.createNewFile()) {
                    System.out.println("Strucutres printed out to a text file: " + fileToPrint.getName());
                    System.out.println("Location: " + fileToPrint.getAbsolutePath());

                } else {
                    Files.delete(Path.of(filePath + fileName));
                    fileToPrint.createNewFile();
                    System.out.println("Strucutres re-printed out to a text file: " + fileToPrint.getName());
                    System.out.println("Location: " + fileToPrint.getAbsolutePath());
                }

                return fileToPrint;

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            return null;
        }


    /**
     *
     * @param content to be written to file
     * @param fileToWrite file to write to
     *
     *
     * WRITES DATA TO A PASSED FILE, WRITES PASSED CONTENTS.
     *
     */
    public static void writeToFile(File fileToWrite, String content) throws IOException {

        if (!fileToWrite.exists() || Objects.equals(content, "")){
            throw new IOException();
        }


            if (fileToWrite.isFile()) {

                try(PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileToWrite, true)))){

                    fileWriter.write(content);
                    fileWriter.write(System.lineSeparator());

                }catch(IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }else{
                System.out.println(" is not a file, or does not exist in directory.");
                //THROW ERROR JACK
            }
        }



}


