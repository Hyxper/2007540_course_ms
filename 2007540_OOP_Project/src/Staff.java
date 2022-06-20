import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


/**
 * A CLASS THAT REPRESENTS A UNIVERSITY MEMEBER OF STAFF
 */
public class Staff extends User implements Staffable {
    private String guid;
    private String avatar;
    @SerializedName("weekly_hours")
    private int weeklyHours;
    @SerializedName("max_modules")
    private int maxModules;

    private ArrayList<Modules> taughtModules;

    @Override
    public String getGuid() {
        return guid;
    }

    @Override
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public String getAvatar() {
        return avatar;
    }

    @Override
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    @Override
    public int getWeeklyHours() {
        return weeklyHours;
    }

    @Override
    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    @Override
    public int getMaxModules() {
        return maxModules;
    }

    @Override
    public void setMaxModules(int maxModules) {
        this.maxModules = maxModules;
    }

    public String getFullName(){
        return this.getFirstName()+" "+this.getLastName();
    }

}
