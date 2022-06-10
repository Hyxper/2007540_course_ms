import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.lang.reflect.Array;
import java.util.ArrayList;

//-------TO DO LIST FOR GUI
//-- TIDY GUI UP
//-- CREATE

public class GUI extends JFrame {

    private JPanel masterPanel;
    private JPanel headerPanel;
    private JPanel treePanel;
    private JPanel leftTreePanel;
    private JPanel rightTreePanel;
    private JTree leftTree;
    private JTree rightTree;
    private JButton button1;
    private JComboBox<String> deptComboBox;
    private JLabel headerLabel;

    private ArrayList<Departments> structure;
    public GUI(ArrayList<Departments> structure){

        this.structure = structure;
        this.setContentPane(masterPanel);
        this.setSize(1200,600);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("PROJECT GUI 2007540");


    }







    private DefaultMutableTreeNode createTreeStructures(ArrayList<Departments> structure, String side, String deptName) {


        if (side.equals("")) {
            System.out.println("NO SIDE PASSED");
        } else if (side.equalsIgnoreCase("right") || side.equalsIgnoreCase("left")) {

            if (side.equalsIgnoreCase("left")) {
                DefaultMutableTreeNode masterNode = new DefaultMutableTreeNode(deptName);
                DefaultMutableTreeNode staffNode = new DefaultMutableTreeNode("Staff");
                DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode("Students");
                DefaultMutableTreeNode courseNode = new DefaultMutableTreeNode("Courses");
                DefaultMutableTreeNode moduleNode = new DefaultMutableTreeNode("Modules");

                masterNode.add(staffNode);
                masterNode.add(staffNode);
                masterNode.add(studentNode);
                masterNode.add(courseNode);
                masterNode.add(moduleNode);

                return masterNode;

            } else {
                DefaultMutableTreeNode masterNode = new DefaultMutableTreeNode("Courses");
                DefaultMutableTreeNode moduleNode = new DefaultMutableTreeNode("Modules");
                DefaultMutableTreeNode staffNode = new DefaultMutableTreeNode("Staff");
                DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode("Students");

                moduleNode.add(staffNode);
                moduleNode.add(studentNode);
                masterNode.add(moduleNode);

                return masterNode;

            }
        }
            return null;
    }

    private String[] createComboBox(){

        ArrayList<Departments> structure = this.getStructure();

        ArrayList<String> temp = new ArrayList<>();
        temp.add("--Please choose a department--");
        for (Departments department: structure) {
            temp.add(department.getSchoolName());
        }
        return temp.toArray(new String[0]);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        ArrayList<Departments> struct = getStructure();
        leftTree = new JTree(createTreeStructures(struct,"left","TEST"));
        rightTree = new JTree(createTreeStructures(struct,"right","TEST"));
        deptComboBox = new JComboBox<>(createComboBox());
    }

    private void $$$setupUI$$$() {
        createUIComponents();
    }

    public ArrayList<Departments> getStructure() {
        return structure;
    }

    public void setStructure(ArrayList<Departments> structure) {
        this.structure = structure;
    }
}
