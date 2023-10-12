package lab4;

import java.util.ArrayList;

public class ArrayAverage {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, null};
        System.out.println(average(arr));

        System.out.println();

        arr = new Integer[]{1, 2, 3, 4, 5, 6};
        System.out.println(average(arr));

        System.out.println();

        arr = new Integer[]{};
        System.out.println(average(arr));

    }

    private static double average(Integer[] arr){
        int sum = 0;
        int count = 0;

        try {
            for (int i = 0;; i++){
                try {
                    sum+=arr[i];
                    count++;
                }
                catch (NullPointerException e){
                    System.out.println(e);
                }

            }
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
        catch (Exception e){
            System.out.println("Unexpected exception but still no crash");
        }

        try {
            if (count == 0){
                throw new ArithmeticException("There are no numbers");
            }
            return ((double) sum) / count;
        }
        catch (ArithmeticException e){
            System.out.println(e);
            return 0;
        }


    }

}
