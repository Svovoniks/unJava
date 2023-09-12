package lab1;

public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println(s  + " " + isPalindrome(s));
        }
    }

    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i > -1; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static boolean isPalindrome(String s){
        return s.equals(reverseString(s));
    }
}