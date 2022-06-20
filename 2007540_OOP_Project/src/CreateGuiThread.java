import java.util.ArrayList;
/**
 * THIS CLASS IS USED TO CREATE A THREAD FOR CREATING GUI
 */
public class CreateGuiThread implements Runnable{



    private GUI createdGUI;

    private final ArrayList<Departments> strucutre;

    CreateGuiThread(ArrayList<Departments> passedStructure){
        this.strucutre = passedStructure;
    }

    @Override
    public void run(){
        createdGUI = new GUI(strucutre);
    }

}
