import java.util.ArrayList;


public class Main{

    public static void main(String[] args) throws InterruptedException {

        //Multiton pattern to create my departments?

        //CHANGE JSON PARSER TO BE JSONABLE VIA INTERFACE (JSONABLE AND LOGGABLE TYPES)
        //ADD MORE POLYMORPHIC & ABSTRACT ELEMENTS
        //ADD ACTION LISTEN
        //ERROR CHECKING
        //make naming less ambiguous
        // ADD A NEW STUDENT OR STAFF
        //COMMENTS AND JDOC
        //add event listener to open window for each student



        //THIS CODE IS COMPLETELY SUPERFLUOUS, THIS SERVES AS AN EXAMPLE OF HOW THREADS HAVE BEEN USED
        //TO GENERATE PROGRAM DEPENDENCIES. JOIN KEYWORD ENSURES THREAD REMAIN SYNCHRONOUS MAKING IT ALMOST
        //POINTLESS.

        //BOTH GENERAL METHODS FOR CREATING A THREAD HAVE BEEN USED. DEPARTMENTS VIA EXTENSION OF THE
        // THREAD CLASS, AND GUI BY IMPLEMENTING

        CreateDepartmentsThread createDeparments = new CreateDepartmentsThread();
        createDeparments.start();
        createDeparments.join();
        ArrayList<Departments> departmentStructures = createDeparments.getStrucutre();
        System.out.println("THREAD "+createDeparments.getName()+" STATE: "+createDeparments.getState());

        CreateGuiThread GUI = new CreateGuiThread(departmentStructures);
        Thread GUIThread = new Thread(GUI);
        GUIThread.setName("GUI_THREAD");
        System.out.println("CREATING GUI ON THREAD: "+GUIThread.getName());
        GUIThread.start();
        GUIThread.join();



//








//        File structureFile = FileParser.createFile("test","2007540_OOP_Project/data/");
//
//        assert structureFile != null;
//        FileParser.writeToFile(structureFile,"1");
//        FileParser.writeToFile(structureFile,"2");
//        FileParser.writeToFile(structureFile,"3");


//        System.out.println(StructureValues.MODULECOUNT.getCount());
//        System.out.println(StructureValues.COURSECOUNT.getCount());
//        System.out.println(FileExtensions.DATAFILES.getExtension());

//
//        Thread t1;
//        t1 = new Thread(() -> FileParser.countUp(1,"t1"));
//        t1.setName("t1");
//        t1.start();
//
//        if(!t1.isAlive()){
//            System.out.println("fin");
//        }
//
//        System.out.println(t1.isAlive());

//        new Thread(() -> FileParser.countUp(100,"t2")).start();
//        new Thread(() -> FileParser.countUp(100,"t3")).start();
//        new Thread(() -> FileParser.countUp(100,"t4")).start();
//        new Thread(() -> FileParser.countUp(100,"t5")).start();









    }


}
