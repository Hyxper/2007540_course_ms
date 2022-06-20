import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;


/**
 * CLASS FOR GUI
 */

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

    private DefaultTreeModel leftModel;

    private DefaultTreeModel rightModel;
    private ArrayList<Departments> structure;

    public GUI(ArrayList<Departments> structure) {

        this.structure = structure;
        this.setContentPane(masterPanel);
        this.setSize(1200, 600);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("PROJECT GUI 2007540");

        //REMOVE STANDARD ROOTS FROM TREE
        removeRoot(leftTree);
        removeRoot(rightTree);
        DefaultTreeModel leftModel = (DefaultTreeModel) leftTree.getModel();
        DefaultTreeModel rightModel = (DefaultTreeModel) rightTree.getModel();


        deptComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //GET SELECTED DEPARTMENT
                String comboValue = Objects.requireNonNull(deptComboBox.getSelectedItem()).toString();
                Departments activeDepartment;


                for (Departments selectedDepartment : getStructure()) {

                    if (comboValue.equals("--Please choose a department--")){

                        //RESET THE DISPLAY
                        removeRoot(leftTree);
                        removeRoot(rightTree);
                        leftModel.reload();
                        rightModel.reload();

                    } else if (comboValue.equals(selectedDepartment.getSchoolName())) {

                        //FIND MATCHING DEPARTMENT FROM STRUCTURE ARRAY
                        activeDepartment = selectedDepartment;
                        formatTree(activeDepartment,leftTree,leftModel,"LEFT");
                        formatTree(activeDepartment,rightTree,rightModel,"RIGHT");

                    }
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Departments> test = getStructure();
                addNewUserGUI addUser = new addNewUserGUI(test);

            }
        });
    }

    /**
     *
     * @param passedDepartment department being generated
     * @param tree passed tree
     * @param model passed tree model
     * @param treeSide string description of passed tree
     *
     *
     * REFORMATS PASSED JTREE TO DISPLAY ASSOCIATED DEPARTMENT INFORMATION
     */
    private void formatTree(Departments passedDepartment, JTree tree, DefaultTreeModel model, String treeSide){
        removeRoot(tree);
        addRoot(tree,createDepartmentRoot(passedDepartment,treeSide));
        model.reload();
    }


    /**
     *
     * @param tree
     *
     * REMOVES ROOT FROM JTREE
     */
    private void removeRoot(JTree tree) {

        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        model.setRoot(null);

    }

    /**
     *
     * @param tree
     * ADDS ROOT FROM JTREE
     */
    private void addRoot(JTree tree, DefaultMutableTreeNode root) {

        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        model.setRoot(root);

    }

    /**
     *
     * @param selectedDepartment department to be generated
     * @param side side to create
     * @return NODE TO USE IN TREE
     * THIS CREATES THE TREE STRUCTURES REQUIRED IN ORDER TO DISPLAY THE CORRECT INFORMATION TO THE USER.
     * PASSING "LEFT" WILL FORMAT LEFT SIDE, WHICH BREAKS THE DEPARTMENT INTO ALL OF ITS MEMBERS, AND
     * PASSING RIGHT BREAKS THE DEPARTMENT DOWN INTO COURSES TO DISPLAY THEIR MEMEBERS
     */

    private DefaultMutableTreeNode createDepartmentRoot(Departments selectedDepartment, String side){

        //DECLARE ALL BASE NODES
        DefaultMutableTreeNode staffNode = new DefaultMutableTreeNode("Staff");
        DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode("Students");
        DefaultMutableTreeNode courseNode = new DefaultMutableTreeNode("Courses");
        DefaultMutableTreeNode moduleNode = new DefaultMutableTreeNode("Modules");

        if (side.equalsIgnoreCase("LEFT")) {

            DefaultMutableTreeNode masterNode = new DefaultMutableTreeNode(selectedDepartment.getSchoolName() + " Breakdown");

            //LOOP THROUGH DEPT STUDENTS AND ADD TO NODE
            for (Student studentToAdd : selectedDepartment.getStudents()) {
                DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(studentToAdd.getFullName());
                studentNode.add(tempNode);
            }

            masterNode.add(studentNode);

            //LOOP THROUGH DEPT STAFF AND ADD TO NODE
            for (Staff staffToAdd : selectedDepartment.getStaff()) {
                DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(staffToAdd.getFullName());
                staffNode.add(tempNode);
            }

            masterNode.add(staffNode);

            //LOOP THROUGH DEPT CORSES AND ADD TO NODE
            for (Courses courseToAdd : selectedDepartment.getCourses()) {
                DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(courseToAdd.getCourseName());
                courseNode.add(tempNode);
            }

            masterNode.add(courseNode);

            //LOOP THROUGH DEPT MODULES AND ADD TO NODE
            for (Modules moduleToAdd : selectedDepartment.getDepartmentModules()) {
                DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(moduleToAdd.getModuleName());
                moduleNode.add(tempNode);
            }

            masterNode.add(moduleNode);

            return masterNode;


        } else if (side.equalsIgnoreCase("RIGHT")){

            //TOP LEVEL NODE FOR RIGHT TREE
            DefaultMutableTreeNode masterNode = new DefaultMutableTreeNode(selectedDepartment.getSchoolName() + " Structure");

            //ADD COURSES TO TOP LEVEL NODE
            for (Courses courseToAdd : selectedDepartment.getCourses()) {

                //CHILDREN OF COURSE NODE
                DefaultMutableTreeNode tempCourseNode = new DefaultMutableTreeNode(courseToAdd.getCourseName());
                DefaultMutableTreeNode tempCourseModuleNode = new DefaultMutableTreeNode("Course Modules");
                DefaultMutableTreeNode tempCourseStudentNode = new DefaultMutableTreeNode("Course Students");


                //ADD STUDENTS & MODULES TO COURSE CHILD NODE
                for (Student studentOnCourse : courseToAdd.getCourseStudents()){

                    DefaultMutableTreeNode courseStudent = new DefaultMutableTreeNode(studentOnCourse.getFullName());
                    tempCourseStudentNode.add(courseStudent);

                }

                //START ADDING MODULE NODES TO EACH COURSE NODE
                for (Modules moduleInCourse : courseToAdd.getcourseModules()){

                    DefaultMutableTreeNode moduleStudentNode = new DefaultMutableTreeNode("Module Students");
                    DefaultMutableTreeNode moduleStaffNode = new DefaultMutableTreeNode("Module Staff");
                    DefaultMutableTreeNode courseModule = new DefaultMutableTreeNode(moduleInCourse.getModuleName());

                    //ADD STUDENTS TO MOUDLE NODE
                    for (Student studentOnModule : moduleInCourse.getStudents()){
                        DefaultMutableTreeNode moduleStudent = new DefaultMutableTreeNode(studentOnModule.getFullName());
                        moduleStudentNode.add(moduleStudent);
                    }


                    //ADD STAFF MEMEBER TO MODULE NODE
                    DefaultMutableTreeNode moduleStaff = new DefaultMutableTreeNode(moduleInCourse.getLecturer().getFullName());
                    moduleStaffNode.add(moduleStaff);

                    //ADD ALL TO COURSE NODE
                    courseModule.add(moduleStudentNode);
                    courseModule.add(moduleStaffNode);
                    tempCourseModuleNode.add(courseModule);

                }


                //ADD NODES TO COURSE NODE
                tempCourseNode.add(tempCourseStudentNode);
                tempCourseNode.add(tempCourseModuleNode);
                courseNode.add(tempCourseNode);
            }

            masterNode.add(courseNode);

            return masterNode;

        }

        return null;

    }

    private ArrayList<Departments> getStructure() {
        return structure;
    }

    public void setStructure(ArrayList<Departments> structure) {
        this.structure = structure;
    }

    private String[] createComboBox() {

        ArrayList<Departments> structure = this.getStructure();

        ArrayList<String> temp = new ArrayList<>();
        temp.add("--Please choose a department--");
        for (Departments department : structure) {
            temp.add(department.getSchoolName());
        }

        return temp.toArray(new String[0]);

    }

    private void createUIComponents() {
        deptComboBox = new  JComboBox<>(createComboBox());
    }

}
