public enum FileExtensions {

    FILEPATH("2007540_OOP_Project/data/"),
    STUDENTS("students.json"),
    STAFF("staff.json"),
    MODULES("modules.json"),
    COURSES("Courses.json"),
    DEPARTMENTS("academic-depts.csv");


    final private String FileExtensions;

    FileExtensions(String FileExtensions){
        this.FileExtensions = FileExtensions;
    }

   public String getExtension(){
        return FileExtensions;
   }

}
