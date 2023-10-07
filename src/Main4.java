import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Main4 {
    public static void main(String[] args) {
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println();

        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println();



    }

    private static String nonRepeatable(String str){
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char i : str.toCharArray()){
            set.add(i);
        }

        StringBuilder builder = new StringBuilder();

        for (char i : set){
            builder.append(i);
        }
        return builder.toString();
    }
    private static ArrayList<String> generateBrackets(int i){
        ArrayList<String> list = new ArrayList<>();
        finish(new StringBuilder(), list, i, i);
        return list;
    }

    private static void finish(StringBuilder begin,
                               ArrayList<String> list,
                               int c_open,
                               int c_closed){
        if (c_open == c_closed && c_closed == 0){
            list.add(begin.toString());
            return;
        }

        if (c_open > 0){
            finish(new StringBuilder(begin).append('('), list, c_open - 1, c_closed);
        }
        if (c_closed > c_open){
            finish(new StringBuilder(begin).append(')'), list, c_open, c_closed - 1);
        }
    }

    private static void binarySystem(int i){
        
    }

}
