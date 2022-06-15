public class myThread extends Thread implements Runnable {


    private int pause;

    myThread(int timeToPause){
        this.setPause(timeToPause);
    }




    @Override
    public void run() {
//        super.run();
        System.out.println("run() Method called");
        printLoop();
    }

    public void printLoop() {

        String threadName = Thread.currentThread().getName();

        for (int i = 0; i < 100; i++) {

            System.out.println("val is "+i+" from thread "+threadName);
            try{
                Thread.sleep(getPause());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }

    public int getPause() {
        return pause;
    }

    public void setPause(int pause) {
        this.pause = pause;
    }
}
