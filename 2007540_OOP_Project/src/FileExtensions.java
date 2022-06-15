public enum FileExtensions {

    DATAFILES("2007540_OOP_Project/data/");

    final private String FileExtensions;

    FileExtensions(String FileExtensions){
        this.FileExtensions = FileExtensions;
    }

   public String getExtension(){
        return FileExtensions;
   }

}
