public class Staff extends User {
    private String guid;
    private String avatar;
    private int weekly_hours;
    private int max_modules;

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


    public int getWeekly_hours() {
        return weekly_hours;
    }

    public void setWeekly_hours(int weekly_hours) {
        this.weekly_hours = weekly_hours;
    }

    public int getMax_modules() {
        return max_modules;
    }

    public void setMax_modules(int max_modules) {
        this.max_modules = max_modules;
    }
}
