/**
 //THIS INTERFACE IS USED TO ENSURE THAT ALL REQUIRED GETTERS AND SETTERS
 // ARE IN PLACE FOR THE STAFF CLASS.
 **/

public interface Staffable extends Userable{

    String getGuid();

    void setGuid(String guid);

    String getAvatar();

    void setAvatar(String avatar);

    int getWeeklyHours();

    void setWeeklyHours(int weeklyHours);

    int getMaxModules();

    void setMaxModules(int maxModules);
}
