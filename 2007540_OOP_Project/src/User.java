import com.google.gson.annotations.SerializedName;

public abstract class User implements Userable{

    private int id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    private String email;
    private String department;

    //ABSTRACT METHOD TO SHOW USE
    public abstract String getFullName();

    @Override
    public void setFirstName(){
        this.firstName = firstName;
    }
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String getDepartment() {
        return department;
    }
    @Override
    public void setDepartment(String department) {
        this.department = department;
    }

}

