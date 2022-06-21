import java.util.ArrayList;


public class Main{

    public static void main(String[] args) throws InterruptedException {


        //add event listener to open window for each student



        //THIS CODE IS COMPLETELY SUPERFLUOUS, THIS SERVES AS AN EXAMPLE OF HOW THREADS HAVE BEEN USED
        //TO GENERATE PROGRAM DEPENDENCIES. JOIN KEYWORD ENSURES THREAD REMAIN SYNCHRONOUS MAKING IT ALMOST
        //POINTLESS.

        //BOTH GENERAL METHODS FOR CREATING A THREAD HAVE BEEN USED. DEPARTMENTS VIA EXTENSION OF THE
        //THREAD CLASS, AND GUI BY IMPLEMENTING RUNNABLE

        CreateDepartmentsThread createDepartments = new CreateDepartmentsThread();
        createDepartments.start();
        createDepartments.join();
        ArrayList<Departments> departmentStructures = createDepartments.getStrucutre();
        System.out.println("THREAD "+createDepartments.getName()+" STATE: "+createDepartments.getState());

        CreateGuiThread GUI = new CreateGuiThread(departmentStructures);
        Thread GUIThread = new Thread(GUI);
        GUIThread.setName("GUI_THREAD");
        System.out.println("CREATING GUI ON THREAD: "+GUIThread.getName());
        GUIThread.start();
        GUIThread.join();








    }


}
