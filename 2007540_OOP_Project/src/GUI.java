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

    private JScrollPane scrollLeft;

    private JScrollPane scrollRight;

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

                    generateTreeData(leftTree,rightTree,comboValue);

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


                moduleNode.add(staffNode);
                moduleNode.add(studentNode);
                masterNode.add(moduleNode);

                return masterNode;

            }
        }
            return null;
    }

    private void generateTreeData(JTree leftTree, JTree rightTree, String department) {


        Departments selectedDepartment = null;

//        System.out.println(leftTree.getModel().getRoot());

        ArrayList<Departments> loadedDepartments = this.getStructure();

        //get details for selected department
        for (Departments tempDepartment : loadedDepartments) {
            if(Objects.equals(tempDepartment.getSchoolName(), department)){
                 selectedDepartment = tempDepartment;
            }
        }

        assert selectedDepartment != null;
        System.out.println(selectedDepartment.getSchoolName());


        for (int i=0; i<leftTree.getModel().getChildCount(leftTree.getModel().getRoot());i++ ){

           DefaultMutableTreeNode tempBranch = (DefaultMutableTreeNode) leftTree.getModel().getChild(leftTree.getModel().getRoot(),i);

           if (Objects.equals(leftTree.getModel().getChild(leftTree.getModel().getRoot(), i).toString(), "Students")){
               for (Student currentStudent : selectedDepartment.getStudents()) {
                   DefaultMutableTreeNode tempLeaf = new DefaultMutableTreeNode(currentStudent.getFullName());
                   tempBranch.add(tempLeaf);
               }

           }else if (Objects.equals(leftTree.getModel().getChild(leftTree.getModel().getRoot(), i).toString(), "Staff")){
                for (Staff currentStaff : selectedDepartment.getStaff()) {
                    DefaultMutableTreeNode tempLeaf = new DefaultMutableTreeNode(currentStaff.getFullName());
                    tempBranch.add(tempLeaf);
                }
            }else if (Objects.equals(leftTree.getModel().getChild(leftTree.getModel().getRoot(), i).toString(), "Courses")) {
               for (Courses currentCourse : selectedDepartment.getCourses()) {
                   DefaultMutableTreeNode tempLeaf = new DefaultMutableTreeNode(currentCourse.getCourseName());
                   tempBranch.add(tempLeaf);
               }
           }else{
               for (Modules currentModule : selectedDepartment.getDepartmentModules()) {
                   DefaultMutableTreeNode tempLeaf = new DefaultMutableTreeNode(currentModule.getName());
                   tempBranch.add(tempLeaf);
               }
           }
        }

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
//        scrollLeft = new JScrollPane(leftTree,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

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
