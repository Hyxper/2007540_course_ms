public enum StructureValues {


    COURSECOUNT(8),
    MODULECOUNT(12);

    private int DepartmentRules;

        StructureValues(int DepartmentRules){
        this.DepartmentRules = DepartmentRules;
        }

//    FILEDIR("2007540_OOP_Project/data/");

        public int getCount(){
            return DepartmentRules;
        }





}
