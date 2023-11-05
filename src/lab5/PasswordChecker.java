package lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {
    public static void main(String[] args) {
        System.out.println(check(null));
        System.out.println(check("abcdef12D"));
        System.out.println(check("abcdefldD"));
    }

    private static boolean check(String password){
        try {
            if (password.length() < 8 || password.length() > 16){
                return false;
            }
        }
        catch (NullPointerException e){
            System.out.println(e);
            return false;
        }


        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.find()){
            return false;
        }

        pattern = Pattern.compile("[A-Z]");
        matcher = pattern.matcher(password);

        if (!matcher.find()){
            return false;
        }

        pattern = Pattern.compile("[a-zA-Z0-9]+");
        matcher = pattern.matcher(password);

        if (!matcher.find() || !matcher.group().equals(password)){
            return false;
        }

        return true;
    }
}
