public enum StructureValues {


    COURSECOUNT(8),
    MODULECOUNT(12);

    private int DepartmentRules;

        StructureValues(int DepartmentRules){
        this.DepartmentRules = DepartmentRules;
        }


        public int getCount(){
            return DepartmentRules;
        }





}
