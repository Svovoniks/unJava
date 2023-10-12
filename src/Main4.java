import lab3.HashTable;

import javax.management.StringValueExp;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main4 {
    public static void main(String[] args) {
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println();

        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println();

        System.out.println(Arrays.toString(binarySystem(3)));
        System.out.println(Arrays.toString(binarySystem(4)));
        System.out.println();

        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println();

        System.out.println(zipAndSort("aaabbcdd"));
        System.out.println(zipAndSort("vvvvaajaaaaa"));
        System.out.println();

        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one") );
        System.out.println();

        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));
        System.out.println();

        System.out.println(shortestWay(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
        System.out.println(shortestWay(new int[][]{
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}
        }));
        System.out.println();

        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println();

        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
        System.out.println();

    }

    private static String nonRepeatable(String str){

        if (str.length() <= 1){
            return str;
        }
        if (str.indexOf(str.charAt(str.length()-1)) != str.length() - 1){
            return nonRepeatable(str.substring(0, str.length() - 1));
        }

        return nonRepeatable(str.substring(0, str.length() - 1)) + str.charAt(str.length() - 1);
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

    private static String[] binarySystem(int len){
        if (len == 0){
            return new String[0];
        }
        if (len == 1){
            return new String[]{"0", "1"};
        }

        ArrayList<String> list = new ArrayList<>();
        for (String str : binarySystem(len - 1)){
            if (str.charAt(str.length() - 1) != '0'){
                list.add(str + '0');
            }
            list.add(str + '1');
        }

        return list.toArray(new String[0]);
    }

    private static String alphabeticRow(String str){
        int maxLen = 0;
        String maxStr = "";
        int curBack = 0;
        int curForw = 0;

        for (int i = 1; i < str.length(); i++){
            switch (str.charAt(i - 1) - str.charAt(i)){
                case 1: {
                    curBack += 1;
                    curForw = 0;
                    break;
                }
                case -1: {
                    curBack = 0;
                    curForw += 1;
                    break;
                }
                default: {
                    curBack = 0;
                    curForw = 0;
                    break;
                }
            }

            if (curBack > maxLen){
                maxStr = str.substring(i - curBack, i + 1);
                maxLen = curBack;
            }
            else if (curForw > maxLen){
                maxStr = str.substring(i - curForw, i + 1);
                maxLen = curForw;
            }


        }
        return maxStr;
    }

    private static String zipAndSort(String str){

        if (str.isEmpty()){
            return "";
        }

        ArrayList<AbstractMap.SimpleEntry<Character, Integer>> list = new ArrayList<>();
        AbstractMap.SimpleEntry<Character, Integer> ab =
                new AbstractMap.SimpleEntry<>(str.charAt(0), 1);

        list.add(ab);

        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i) == str.charAt(i - 1)){
                ab = new AbstractMap.SimpleEntry<>(str.charAt(i), list.get(list.size() - 1).getValue() + 1);
                list.set(list.size() - 1, ab);
            }
            else {
                ab = new AbstractMap.SimpleEntry<>(str.charAt(i), 1);
                list.add(ab);
            }
        }
        StringBuilder builder = new StringBuilder();

        for (AbstractMap.SimpleEntry<Character, Integer> item :
            list.stream().sorted(Comparator.comparingInt(AbstractMap.SimpleEntry::getValue)).toArray(AbstractMap.SimpleEntry[]::new)){
            builder.append(item.getKey()).append(item.getValue());
        }

        return builder.toString();

    }

    //only less than 1000
    private static int convertToNum(String str){
        String[] arr = str.split(" ");

        ArrayList<String> single =new ArrayList<>(List.of(
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine"
        ));

        ArrayList<String> tens = new ArrayList<>(List.of(
                "zero",
                "ten",
                "twenty",
                "thirty",
                "forty",
                "fifty",
                "sixty",
                "seventy",
                "eighty",
                "ninety"
        ));

        int number = 0;

        for (String s : arr){
            int idx = single.indexOf(s);
            if (idx != -1){
                number += idx;
                continue;
            }

            idx = tens.indexOf(s);
            if (idx != -1){
                number += idx * 10;
                continue;
            }

            if (s.equals("hundred")){
                number *= 100;
                continue;
            }

            if (s.equals("thousand")){
                number *= 1000;
            }
        }

        return number;
    }


    private static String uniqueSubstring(String str){
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        int maxLen = 0;
        StringBuilder builder = new StringBuilder();

        for (char ch : str.toCharArray()){
            if (!set.contains(ch)){
                set.add(ch);
            }
            else {
                if (maxLen < set.size()){
                    maxLen = set.size();
                    builder = new StringBuilder();
                    set.forEach(builder::append);
                }
                set = new LinkedHashSet<>();
                set.add(ch);
            }

        }

        if (maxLen < set.size()){
            builder = new StringBuilder();
            set.forEach(builder::append);
        }

        return builder.toString();
    }

    private static int shortestWay(int[][] arr){
        return shortestWay(arr, arr.length, arr[0].length);

    }

    private static int shortestWay(int[][]arr, int limitX, int limitY){
        if (limitX == 0){
            return 0;
        }

        if (limitX == 1 && limitY == 1){
            return arr[0][0];
        }

        if (limitX == 1){
            return arr[limitX-1][limitY-1] + shortestWay(arr, limitX, limitY - 1);
        }

        if (limitY == 1){
            return arr[limitX-1][limitY-1] + shortestWay(arr, limitX - 1, limitY);
        }

        return arr[limitX-1][limitY-1] + Math.min(shortestWay(arr, limitX - 1, limitY),
                shortestWay(arr, limitX, limitY - 1));
    }

    private static <T> void swap(T[] arr, int idx1, int idx2){
        T temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }


    private static String numericOrder(String str){
        String[] arr = str.split(" ");

        Pattern pattern = Pattern.compile("\\d+");

        for (int i = 0; i < arr.length; i++){
            Matcher matcher = pattern.matcher(arr[i]);
            if (matcher.find()){
                String found = arr[i].substring(matcher.start(), matcher.end());
                int dest = Integer.parseInt(found);
                arr[i] = arr[i].replace(found, "");
                swap(arr, i, dest - 1);
                i--;
            }
        }

        StringBuilder builder = new StringBuilder();
        Arrays.stream(arr).forEach((a) -> builder.append(a).append(" "));
        builder.delete(builder.length() - 1, builder.length());

        return builder.toString();
    }

    public static int switchNums(int num1, int num2){
        Integer[] arr = Arrays.stream(String.valueOf(num1).split("")).map(Integer::parseInt).toArray(Integer[]::new);

        Arrays.sort(arr, Comparator.reverseOrder());
        int result = 0;
        int arrIdx = 0;

        for (char ch : String.valueOf(num2).toCharArray()){
            result *= 10;
            if (ch - 48 < arr[arrIdx]){
                result += arr[arrIdx];
                arrIdx++;
            }
            else {
                result += ch - 48;
            }
        }

        return result;

    }
}
