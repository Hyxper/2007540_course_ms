import javax.swing.*;
import java.util.ArrayList;

//-------TO DO LIST FOR GUI
//-- CREATE SHELL FOR ALL DATA







public class GUI extends JFrame {


    private JPanel masterPanel;
    private JPanel headerPanel;
    private JPanel treePanel;
    private JPanel leftTreePanel;
    private JPanel rightTreePanel;
    private JTree tree1;
    private JTree tree2;
    private JButton button1;
    private JComboBox<String> deptSelect;

    public GUI(ArrayList<Departments> structure){



        //content for dropdown box


        this.setContentPane(masterPanel);
        this.setSize(1200,600);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("PROJECT GUI 2007540");

        ArrayList<String> deptNamesPre = new ArrayList<>();
        for (Departments department: structure) {
            String temp = department.getSchoolName();
            deptSelect.addItem(temp);
        }





    }



//    private void createUIComponents(ArrayList<Departments> structure) {
//        // TODO: place custom component creation code here
//
//
//
//        ArrayList<String> deptNamesPre = new ArrayList<>();
//        for (Departments department: structure) {
//            deptNamesPre.add(department.getSchoolName());
//        }
//        String[] deptNames = deptNamesPre.toArray(new String[0]);
//
//        JComboBox<String> deptSelect = new JComboBox<>(deptNames);
//    }


}
