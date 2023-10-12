package lab7;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class ParallelSum {

    private static class Calc implements Runnable{
        int[] arr;
        int sum;
        private Calc(int[] arr){
            this.arr = arr;
            sum = 0;
        }

        @Override
        public void run() {
            sum = Arrays.stream(arr).sum();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Calc calc1 = new Calc(Arrays.copyOfRange(arr, 0, arr.length / 2));
        Calc calc2 = new Calc(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
        Thread thread1 = new Thread(calc1);
        Thread thread2 = new Thread(calc2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        int sum = calc1.sum + calc2.sum;
        System.out.println(sum);
        System.out.println(Arrays.stream(arr).sum());
    }
}
