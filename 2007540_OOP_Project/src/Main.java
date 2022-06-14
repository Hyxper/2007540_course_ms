import java.util.ArrayList;


public class Main implements Dependencies{

    public static void main(String[] args){

        //Multiton pattern to create my departments?

        //CHANGE JSON PARSER TO BE JSONABLE VIA INTERFACE
        //ADD MORE POLYMORPHIC & ABSTRACT ELEMENTS
        //ERROR CHECKING
        //make naming less ambiguous
        //FINAL vars


        ArrayList<Departments> departmentStructres = Initialise.InitialiseDepartments();

        assert departmentStructres != null;
        final GUI gui = new GUI(departmentStructres);



    }

}
