package self_study.rest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    static Long factorial(int number){
        return 122L;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadpool1 = Executors.newCachedThreadPool();
        ExecutorService threadpool2 = Executors.newCachedThreadPool();
        Future<Long> futureTask = threadpool1.submit(() -> factorial(12));

        while (!futureTask.isDone()) {
            System.out.println("is not finished yet...");
        }
        long result = futureTask.get();
        threadpool1.shutdown();
        System.out.println("Done");
    }

}

