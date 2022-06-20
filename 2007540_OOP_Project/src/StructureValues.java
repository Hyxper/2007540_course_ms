/**
 * ENUM THAT LISTS VALUES NEEDED IN ORDER TO CREATE COURSES AND DEPARTMENTS
 */


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
