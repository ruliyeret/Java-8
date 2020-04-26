package Threads;

import java.util.concurrent.*;

public class CallablesANDfutures {


    /*
    @callable - function like runnable but return value
    @Future - the return from callable
    @Future.get() - block until the callable return the value
    @Future.isDone() - ask if the callable as returned value
    @ExecutorService - manager of threads
    @Executor.submit - get a runnable / callable and execute the threads
 */

    public static void waitUntilCallableReturnValue(Future<Integer> f) throws ExecutionException, InterruptedException {
        int result  = f.get();
        System.out.println("future done? " + f.isDone());
        System.out.println("result: " + result);
    }

    public static void waitUntilCallableReturnValueWithTimeOut(Future<Integer> f) throws ExecutionException,
                                                                                    InterruptedException, TimeoutException {
            int result = f.get(1, TimeUnit.MILLISECONDS);
            System.out.println("future done? " + f.isDone());
            System.out.print("result: " + result);

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(task);
        try {
            waitUntilCallableReturnValueWithTimeOut(future);
        }catch (TimeoutException e){
            System.out.println("TimelimitExeption because the callable not return at configure time");
        }

        waitUntilCallableReturnValue(future);


        executor.shutdown();
    }
}
