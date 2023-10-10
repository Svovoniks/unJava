package lab7;

import java.awt.datatransfer.FlavorListener;
import java.util.*;

public class ParallelMatrix {
    private static class Calc implements Runnable{

        int[][] matrix;
        int line;
        public int max;
        private Calc(int[][] matrix, int line){
            this.matrix = matrix;
            this.line = line;
            this.max = matrix[line][0];
        }
        @Override
        public void run() {
            OptionalInt i = Arrays.stream(matrix[line]).max();
            max = i.isPresent() ? i.getAsInt() : max;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {1, 3, 4}, {2, 3, 6}};

        Calc[] calcs = new Calc[matrix.length];
        Thread[] threads = new Thread[matrix.length];

        for (int i = 0; i < matrix.length; i ++){
            calcs[i] = new Calc(matrix, i);
            threads[i] = new Thread(calcs[i]);
        }

        for (Thread t : threads){
            t.start();
        }

        try {
            for(Thread t : threads){
                t.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int max = calcs[0].max;

        for (Calc c : calcs){
            max = Math.max(max, c.max);
        }

        System.out.println(max);


    }
}
