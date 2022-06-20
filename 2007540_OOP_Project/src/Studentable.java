/**
 //THIS INTERFACE IS USED TO ENSURE THAT ALL REQUIRED GETTERS AND SETTERS
 // ARE IN PLACE FOR THE STUDENT CLASS.
 **/

public interface Studentable extends Userable {


    String getGender();

    void setGender(String gender);

    String getType();

    void setType(String type);

    Courses getStudentCourse();

    void setStudentCourse(Courses studentCourse);
}
