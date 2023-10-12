package lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Links {
    public static void main(String[] args) {
        System.out.println(replaceLinks("some links: https://www.google.com https://www.google.comddd https://www.google.com"));
    }

    private static String replaceLinks(String str){
        try {
            Pattern pattern = Pattern.compile("https?://[^\\s]+");
            Matcher matcher = pattern.matcher(str);

            str = matcher.replaceAll(matchResult -> "<a href=\"" +  matchResult.group() + "\">" + matchResult.group() + "</a>");
        }
        catch (NullPointerException e){
            System.out.println(e);
            return null;
        }

        return str;
    }
}
