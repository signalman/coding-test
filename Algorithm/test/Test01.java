package test;

import java.util.concurrent.ForkJoinPool;

public class Test01 {

    public static void main(String[] args) {
        ForkJoinPool forkjoinPool = new ForkJoinPool(5);
        for(short i= 0; i<10; i++){
            System.out.println("hi");
        }
    }
}
