package lab4;

import java.util.ArrayList;

public class ArrayAverage {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, null};
        int sum = 0;
        int count = 0;

        try {
            for (int i = 0;; i++){
                sum+=arr[i];
                count++;
            }
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
        catch (NullPointerException ex){
            System.out.println(ex);
        }

        System.out.println(sum/count);
    }

}
