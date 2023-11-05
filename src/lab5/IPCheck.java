package lab5;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPCheck {
    public static void main(String[] args) {
        System.out.println(check("1.1.1.1"));
        System.out.println(check("12.1.1.13"));
        System.out.println(check("12.1.1.913"));
    }

    private static boolean check(String ip){
        try {
            Pattern pattern = Pattern.compile(
                    "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
            Matcher matcher = pattern.matcher(ip);
            return matcher.matches();
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }
}
