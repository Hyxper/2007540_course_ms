import java.io.File;
import java.util.ArrayList;


public class Main implements Dependencies{

    public static void main(String[] args){

        //Multiton pattern to create my departments?

        //CHANGE JSON PARSER TO BE JSONABLE VIA INTERFACE
        //ADD MORE POLYMORPHIC & ABSTRACT ELEMENTS
        //ADD ACTION LISTEN
        //ERROR CHECKING
        //make naming less ambiguous
        // ADD A NEW STUDENT OR STAFF
        //FINAL vars


        ArrayList<Departments> departmentStructres = Initialise.InitialiseDepartments();

        assert departmentStructres != null;
//        final GUI gui = new GUI(departmentStructres);

        File structureFile = FileParser.createFile("test","2007540_OOP_Project/data/");
        assert structureFile != null;
        FileParser.writeToFile(structureFile,"1");
        FileParser.writeToFile(structureFile,"2");
        FileParser.writeToFile(structureFile,"3");

    }

}
