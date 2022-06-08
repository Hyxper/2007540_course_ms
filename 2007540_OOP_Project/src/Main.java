import java.util.ArrayList;


public class Main implements Dependencies{


    public static void main(String[] args){

        //Multiton pattern to create my departments?

        //CHANGE JSON PARSER TO BE JSONABLE VIA INTERFACE
        //ADD MORE POLYMORPHIC & ABSTRACT ELEMENTS
        //GUI
        //ERROR CHECKING
        //USER AND STUDENT LOGIN
        //USER AND STUDENT PERMISSIONS
        //make naming less ambiguous
        //FINAL vars
        //START DESIGN GUI RETARD

        ArrayList<Departments> departmentStructres = Initialise.InitialiseDepartments();

        assert departmentStructres != null;
        GUI gui = new GUI(departmentStructres);

//        if (departmentStructres != null) {
//            for (Departments department: departmentStructres) {
//                System.out.println("-------------"+department.getSchoolName()+"-------------");
//                for (Staff staffMemeber : department.getStaff()) {
//                    System.out.println(staffMemeber.getFirstName() + " " + staffMemeber.getLastName());
//                }
//            }
//        }


    }

}
