package lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFinder {
    public static void main(String[] args) {
        showRightWords("the problems of falling up off the tiny mass of the asteroid",
                't');
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
