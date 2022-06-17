import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class Student extends User implements Studentable {
    private String gender;
    private String type;

    private Courses studentCourse;

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Courses getStudentCourse() {
        return studentCourse;
    }

    @Override
    public void setStudentCourse(Courses studentCourse) {
        this.studentCourse = studentCourse;
    }

    public String getFullName(){
        return this.getFirstName()+" "+this.getLastName();
    }


}
