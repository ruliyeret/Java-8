package Threads;


/*
    Join - Waits for this thread to die.
 */
public class JoinExample extends Thread {

    @Override
    public void run(){
        System.out.println("Enter " + currentThread().getName() + ":run");

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        JoinExample j1 = new JoinExample();
        JoinExample j2 = new JoinExample();
        Object obj = new Object();

        j1.start();
        j2.start();

        try {
            j1.join();
            j2.join();
        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        // calls after the thread ended
        System.out.println("Main ended");
    }

}
