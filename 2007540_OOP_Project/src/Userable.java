/**
 THIS INTERFACE IS USED TO ENSURE THAT ALL REQUIRED GETTERS AND SETTERS
 ARE IN PLACE FOR THE ABSTRACT CLASS.
 **/


public interface Userable




{
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setEmail(String email);
    void setId(int id);
    void setDepartment(String department);


    String getFirstName();
    String getLastName();
    String getEmail();
    int getId();
    String getDepartment();


}
