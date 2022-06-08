import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;

public class GUI extends JFrame {

    public GUI(ArrayList<Departments> structure){
        this.setTitle("Demo");
        this.setSize(800,400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


//        DefaultMutableTreeNode departmentCourses = new DefaultMutableTreeNode("Courses");
//        DefaultMutableTreeNode courseModules = new DefaultMutableTreeNode("Modules");
//        DefaultMutableTreeNode moduleStudents = new DefaultMutableTreeNode("Staff");
//        DefaultMutableTreeNode moduleStaff = new DefaultMutableTreeNode("Students");


        for (Departments department: structure) {

            DefaultMutableTreeNode deptRootNode = new DefaultMutableTreeNode(department.getSchoolName());

            for (Courses course : department.getCourses()) {
                DefaultMutableTreeNode courseRootNode = new DefaultMutableTreeNode(course.getCourseName());
                deptRootNode.add(courseRootNode);
            }

            JTree deptTree = new JTree(deptRootNode);
           this.add(deptTree);
        }



//        departmentCourses.add(courseModules);
//        courseModules.add(moduleStaff);
//        courseModules.add(moduleStudents);











    }


}
