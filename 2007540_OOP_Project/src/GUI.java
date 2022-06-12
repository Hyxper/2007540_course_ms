import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Objects;

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



        //if (Objects.requireNonNull(deptComboBox.getSelectedItem()) != "--Please choose a department--"){

        deptComboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent changeValue) {

                String comboValue = Objects.requireNonNull(deptComboBox.getSelectedItem()).toString();

                if (!Objects.equals(comboValue, "--Please choose a department--")){

                    generateTreeData(leftTree,rightTree,"hello");

                };


            }
        });
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

                DefaultMutableTreeNode test = new DefaultMutableTreeNode("test");


                moduleNode.add(staffNode);
                moduleNode.add(studentNode);
                masterNode.add(moduleNode);

                return masterNode;

            }
        }
            return null;
    }

    private static void generateTreeData(JTree leftTree, JTree rightTree, String department){
        System.out.println(department);

        System.out.println( leftTree.getModel().getRoot());
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
