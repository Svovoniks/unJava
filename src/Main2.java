import java.util.Arrays;
import java.util.Random;

class Main2 {
    public static void main(String[] args){
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println();

        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        System.out.println();

        System.out.println(differenceEvenOdd(new int[]{44, 32, 86, 19}));
        System.out.println(differenceEvenOdd(new int[]{22, 50, 16, 63, 31, 55}));
        System.out.println();

        System.out.println(equalToAvg(new int[]{1, 2, 3}));
        System.out.println(equalToAvg(new int[]{1, 2, 3, 4, 6}));
        System.out.println();

        System.out.println(Arrays.toString(indexMult(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(indexMult(new int[]{3, 3, -2, 408, 3, 31})));
        System.out.println();

        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println();

        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println();

        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));
        System.out.println();

        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println();

        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
        System.out.println();
    }

    public static boolean duplicateChars(String st){
        char[] chr = st.toLowerCase().toCharArray();
        Arrays.sort(chr);
        for (int i = 1; i < chr.length; i++){
            if (chr[i] == chr[i-1]) return true;
        }
        return false;
    }

    public static String getInitials(String name) {
        char[] initials = new char[2];
        initials[0] = name.charAt(0);
        initials[1] = name.charAt(name.indexOf(' ') + 1);

        return new String(initials);
    }
    public static int differenceEvenOdd(int[] arr) {
        int diff = 0;
        for (int i : arr){
            if (i % 2 == 0) diff += i;
            else diff -= i;
        }
        return Math.abs(diff);
    }

    public static boolean equalToAvg(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += i;

        for (int i : arr){
            if ((double) sum /arr.length == ((double) i)) return true;
        }
        return false;
    }

    public static int[] indexMult(int[] arr) {
        for (int i = 0; i < arr.length; i++) arr[i] *= i;
        return arr;
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static int Tribonacci(int num) {
        int n1 = 0;
        int n2 = 0;
        int n3 = 1;

        if (num == 1) return n1;
        if (num == 2) return n2;
        if (num == 3) return n3;

        for (int i = 4; i < num; i++){
            int n4 = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = n4;
        }
        return n1 + n2 + n3;
    }

    public static String pseudoHash(int num) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random(num);
        for (int i = 0; i < num; i++){
            builder.append(Integer.toHexString(random.nextInt(16)));
        }
        return builder.toString();
    }

    public static String botHelper(String message) {
        if (message.toLowerCase().contains("help")){
            return "Calling for a staff member";
        }
        else {
            return "Keep waiting";
        }
    }

    public static boolean isAnagram(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr2);

        return new String(arr1).equals(new String(arr2));
    }
}