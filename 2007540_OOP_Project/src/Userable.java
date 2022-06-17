public interface Userable

    //THIS INTERFACE IS USED TO ENSURE THAT ALL REQUIRED GETTERS AND SETTERS
        // ARE IN PLACE FOR THE ABSTRACT CLASS.


{
    void setFirstName();
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
