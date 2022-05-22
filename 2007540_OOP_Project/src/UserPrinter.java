
//BOUND GENERIC

public class UserPrinter <T extends User>{

    T user;

    public UserPrinter(T user){
        this.user = user;
    }

    public void print(){

    }

}
