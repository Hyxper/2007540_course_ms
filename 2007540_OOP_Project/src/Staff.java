import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Staff extends User {
    private String guid;
    private String avatar;
    @SerializedName("weekly_hours")
    private int weeklyHours;
    @SerializedName("max_modules")
    private int maxModules;

    private ArrayList<Modules> taughtModules;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public int getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    public int getMaxModules() {
        return maxModules;
    }

    public void setMaxModules(int maxModules) {
        this.maxModules = maxModules;
    }


}
