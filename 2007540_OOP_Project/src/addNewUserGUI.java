import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;


/**
 * GUI THAT ALLOWS FOR NEW USERS TO BE ADDED, OPENED DIRECTLY FROM PROJECT GUI OBJECT VIA BUTTON PRESS.
 */
public class addNewUserGUI extends JFrame {

    private ArrayList<Departments> structure;
    private JComboBox<String> userCombo;
    private JComboBox<String> deptCombo;
    private JPanel ufMasterPanel;
    private JTextField fNameField;
    private JTextField lNameField;
    private JButton addUserButton;

    addNewUserGUI(ArrayList<Departments> structure){
        this.structure=structure;
        this.setContentPane(ufMasterPanel);
        this.setResizable(false);
        this.setSize(400,300);
        this.setVisible(true);
        this.setTitle("ADD NEW USER");
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chosenDept = Objects.requireNonNull(deptCombo.getSelectedItem()).toString();
                String userType = Objects.requireNonNull(userCombo.getSelectedItem()).toString();

                if (!Objects.equals(fNameField.getText(), "") || !Objects.equals(lNameField.getText(), "" )){
                    String fName = fNameField.getText();
                    String lName = lNameField.getText();
                    insertNewUser(fName,lName,chosenDept,userType);
                    JOptionPane.showMessageDialog(null, "NEW "+userType+" "+fName+" "+lName+" ADDED TO "+chosenDept+". PLEASE RESELECT TREE BRANCH TO SEE CHANGES");
                    fNameField.setText("");
                    fNameField.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "BOTH NAME FIELDS MUST BE FILLED!");
                }

            }
        });
    }

    private void insertNewUser(String fName, String lName, String department, String userType){

        for (Departments chosenDept : getStructure()) {
            if (chosenDept.getSchoolName().equals(department)){
                if (userType.equals("Student")){
                    Student tempStudent = new Student();
                    tempStudent.setDepartment(department);
                    tempStudent.setFirstName(fName);
                    tempStudent.setLastName(lName);
                    chosenDept.getStudents().add(tempStudent);

                }else{
                    Staff tempStaff = new Staff();
                    tempStaff.setDepartment(department);
                    tempStaff.setFirstName(fName);
                    tempStaff.setLastName(lName);
                    chosenDept.getStaff().add(tempStaff);
                }
            }
        }


    }

    private String[] createDeptComboBox() {

        ArrayList<Departments> structure = this.getStructure();

        ArrayList<String> temp = new ArrayList<>();
        for (Departments department : structure) {
            temp.add(department.getSchoolName());
        }

        return temp.toArray(new String[0]);

    }

    private String[] createUserComboBox() {


        ArrayList<String> temp = new ArrayList<>();
        temp.add("Student");
        temp.add("Staff");

        return temp.toArray(new String[0]);

    }

    private ArrayList<Departments> getStructure() {
        return structure;
    }

    public void setStructure(ArrayList<Departments> structure) {
        this.structure = structure;
    }
//
    private void createUIComponents() {
        deptCombo = new  JComboBox<>(createDeptComboBox());
        userCombo = new JComboBox<>(createUserComboBox());
    }

    }

