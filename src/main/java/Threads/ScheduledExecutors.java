package Threads;

import java.sql.Time;
import java.util.concurrent.*;

/*
        @ScheduledExecutorService - manager of threads with option to schedule service
        @future.getDelay - the time that future wait until he get the result
        @ScheduledFuture - future that handle  result from Scheduled executor

      */

public class ScheduledExecutors {


    public static void getDelay( ScheduledFuture<?> f){
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long remainingDelay = f.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms ", remainingDelay);

    }


    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        ScheduledFuture<?> future = executor.schedule(task, 5, TimeUnit.SECONDS);

        getDelay(future);


        executor.shutdown();
    }
}
