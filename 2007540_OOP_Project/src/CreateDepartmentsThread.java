import java.util.ArrayList;
/**
 * THIS CLASS IS USED TO CREATE A THREAD FOR CREATING DEPARTMENTS
 */
public class CreateDepartmentsThread extends Thread {



    private ArrayList<Departments> createdDepartments;

    @Override
    public void run(){
        this.setName("CREATE_DEPARTMENTS");
        System.out.println("CREATING DEPARTMENT STRUCTURES ON THREAD: "+this.getName());
        createdDepartments = Initialise.InitialiseDepartments();
    }

    public ArrayList<Departments> getStrucutre(){

        if (createdDepartments.size() == 0){
            System.out.println("DEPARTMENTS NOT INSTANTIATED");
        }else{
            return this.createdDepartments;
        }
        return null;
    }





}
