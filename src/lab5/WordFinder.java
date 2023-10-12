package lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFinder {
    public static void main(String[] args) {
        showRightWords("hello goodbye there are thousands, ways to die", 't');
    }

    private static void showRightWords(String str, char letter){
        try {
            Pattern pattern = Pattern.compile("\\b" + letter + "\\w*\\b");
            Matcher matcher = pattern.matcher(str);

            while (matcher.find()){
                System.out.println(matcher.group());
            }
        }catch (Exception ex){
            System.out.println(ex);
        }


    }
}
