import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

//-------TO DO LIST FOR GUI
//-- CREATE SHELL FOR ALL DATA







public class GUI extends JFrame {

    public GUI(ArrayList<Departments> structure){
        this.setTitle("Demo");
        this.setSize(1200,600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        //master panel
        JPanel panelMaster = new JPanel();
        Border borderBlack = BorderFactory.createLineBorder(Color.black);
        JLabel title = new JLabel("Course Management System");


        //panels (BOTH TREES, AND HEADER)
        JPanel panelHeader = new JPanel();
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        panelLeft.setBorder(borderBlack);
        panelRight.setBorder(borderBlack);

        JLabel labelLeft = new JLabel("label left");
        JLabel labelRight = new JLabel("label right");
        panelLeft.add(labelLeft);
        panelRight.add(labelRight);

        //content for dropdown box
        ArrayList<String> deptNamesPre = new ArrayList<>();
        for (Departments department: structure) {
            deptNamesPre.add(department.getSchoolName());
        }

        String[] deptNames = deptNamesPre.toArray(new String[0]);

        JComboBox<String> deptSelect = new JComboBox<>(deptNames);

        deptSelect.setSize(120,60);



        panelHeader.setLayout(new BorderLayout());
        panelHeader.add(deptSelect, BorderLayout.SOUTH);
        panelHeader.add(title,  BorderLayout.NORTH);
        panelHeader.setBorder(borderBlack);

        panelMaster.setLayout(new BorderLayout());
        panelMaster.add(panelHeader,BorderLayout.NORTH);
        panelMaster.add(panelRight, BorderLayout.EAST);
        panelMaster.add(panelLeft, BorderLayout.WEST);

        this.add(panelMaster);
        this.setVisible(true);

//        DefaultMutableTreeNode departmentCourses = new DefaultMutableTreeNode("Courses");
//        DefaultMutableTreeNode courseModules = new DefaultMutableTreeNode("Modules");
//        DefaultMutableTreeNode moduleStudents = new DefaultMutableTreeNode("Staff");
//        DefaultMutableTreeNode moduleStaff = new DefaultMutableTreeNode("Students");


//        for (Departments department: structure) {
//
//            DefaultMutableTreeNode deptRootNode = new DefaultMutableTreeNode(department.getSchoolName());
//
//            for (Courses course : department.getCourses()) {
//                DefaultMutableTreeNode courseRootNode = new DefaultMutableTreeNode(course.getCourseName());
//                deptRootNode.add(courseRootNode);
//            }
//
//            JTree deptTree = new JTree(deptRootNode);
//           this.add(deptTree);
//        }



//        departmentCourses.add(courseModules);
//        courseModules.add(moduleStaff);
//        courseModules.add(moduleStudents);











    }


}
