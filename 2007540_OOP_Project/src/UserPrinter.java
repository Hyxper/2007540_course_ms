
//BOUND GENERIC

public class UserPrinter <T extends User>{

    T user;


    public void Test(T item){
        this.user = item;
    }

    public T getItem() {
        return user;
    }

    public void setItem(T item) {
        this.user = item;
    }

    public void showItemDetails(){
        System.out.println("Value of the item: "
                + user);
        System.out.println("Type of the item: "
                + user.getClass().getName());
    }

}
