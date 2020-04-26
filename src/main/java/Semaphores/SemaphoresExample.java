package Semaphores;

import sun.applet.Main;

import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;


/*
        A Java Semaphore example to limit the number of tasks running in ExecutorService.
        In this example, 5 Callable tasks are submitted to ExecutorService,
        but only 2 tasks are running concurrently.
      // Only 2 tasks are able to run concurrently
        TaskLimitSemaphore obj = new TaskLimitSemaphore(executor, 2);
 */
public class SemaphoresExample {

    public ExecutorService executorService = Executors.newFixedThreadPool(10);
    private Semaphore semaphore = new Semaphore(5);


    public Runnable longRunningTask = () ->{

        boolean permit = false;
        try {
            permit = this.semaphore.tryAcquire(1, TimeUnit.SECONDS);
            if (permit) {
                System.out.println(String.format("%s%s%s","Semaphore acquired and have ",
                        String.valueOf(this.semaphore.availablePermits()),
                        " tickets"));
                sleep(5);
            } else {
                System.out.println("Could not acquire semaphore");
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        } finally {
            if (permit) {
                semaphore.release();
            }
        }
    };

    public static void main(String args[]){

        SemaphoresExample semaphoresExample = new SemaphoresExample();

        IntStream.range(0,10).forEach(
                i -> semaphoresExample.executorService.submit(semaphoresExample.longRunningTask));

        semaphoresExample.executorService.shutdown();

    }
}
