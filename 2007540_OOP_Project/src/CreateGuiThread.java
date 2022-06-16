import java.util.ArrayList;

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
