import com.sun.nio.sctp.AbstractNotificationHandler;

import javax.naming.NoPermissionException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.time.Year;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main6 {
    public static void main(String[] args) {
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));

        System.out.println();

        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));

        System.out.println();

        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));

        System.out.println();

        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15)));

        System.out.println();

        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));

        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));

        System.out.println();

        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));

        System.out.println();

        System.out.println(bgenerateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println(bgenerateNonconsecutive("6 - 18 / (-1 + 4)"));

        System.out.println();
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));

        System.out.println();
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));

    }

    public static String hiddenAnagram(String message, String key) {
        message = message.toLowerCase().replaceAll("[ \\p{Punct}0-9]", "");
        key = key.toLowerCase().replaceAll("[ \\p{Punct}0-9]", "");

        int correctness = 0;
        HashMap<Character, int[]> map = new HashMap<>();

        for (char c : key.toCharArray()) {
            map.putIfAbsent(c, new int[]{0, 0});
            map.get(c)[0]++;
        }

        for (int i = 0; i < key.length(); i++) {
            if (map.containsKey(message.charAt(i))) {
                int[] arr = map.get(message.charAt(i));
                correctness += arr[0] == arr[1] ? -1 : 0;
                arr[1]++;
                correctness += arr[0] == arr[1] ? 1 : 0;
            }
        }

        if (correctness == map.size()) {
            return message.substring(0, key.length());
        }

        for (int i = key.length(); i < message.length(); i++) {
            if (map.containsKey(message.charAt(i - key.length()))) {
                int[] arr = map.get(message.charAt(i - key.length()));
                correctness += arr[0] == arr[1] ? -1 : 0;
                arr[1]--;
                correctness += arr[0] == arr[1] ? 1 : 0;
            }
            if (map.containsKey(message.charAt(i))) {
                int[] arr = map.get(message.charAt(i));
                correctness += arr[0] == arr[1] ? -1 : 0;
                arr[1]++;
                correctness += arr[0] == arr[1] ? 1 : 0;
            }
            if (correctness == map.size()) {
                return message.substring(i - key.length() + 1, i + 1);
            }
        }
        return "notfound";
    }

    public static String[] collect(String str, int count) {
        String[] arr = new String[str.length() / count];
        collectAll(str, count, arr, 0);
        Arrays.sort(arr);
        return arr;
    }

    public static void collectAll(String str, int count, String[] arr, int curIdx) {
        arr[curIdx] = str.substring(curIdx * count, (curIdx + 1) * count);
        if (curIdx == arr.length - 1) {
            return;
        }

        collectAll(str, count, arr, curIdx + 1);
    }

    public static String nicoCipher(String message, String key) {
        int[] order = new int[key.length()];

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < key.length(); i++) {
            map.put(key.charAt(i), i);
        }

        Character[] keyArr = map.keySet().toArray(new Character[0]);
        Arrays.sort(keyArr);

        for (int i = 0; i < keyArr.length; i++) {
            order[i] = map.get(keyArr[i]);
        }

        StringBuilder result = new StringBuilder();
        for (int line = 0; line < Math.ceil((double) message.length() / key.length()); line++) {
            for (int column : order) {
                int idx = line * key.length() + column;
                if (idx >= message.length()) {
                    result.append(" ");
                    continue;
                }
                result.append(message.charAt(line * key.length() + column));
            }
        }

        return result.toString();
    }

    public static int[] twoProduct(int[] arr, int product) {
        int[] result = new int[0];

        int gap = arr.length;

        for (int i = 0; i < arr.length; i++) {
            if (product % arr[i] != 0) {
                continue;
            }
            for (int j = i - 1; j > -1; j--) {
                if (arr[i] * arr[j] == product && gap > i - j) {
                    result = new int[]{arr[j], arr[i]};
                    gap = i - j;
                }
            }
        }

        return result;
    }

    public static int[] isExact(int num) {
        return isExact(num, 2, 1);
    }

    public static int[] isExact(int num, int factor, int cur) {
        cur *= factor;
        if (num == cur) {
            return new int[]{num, factor};
        }
        if (num < cur) {
            return new int[0];
        }

        return isExact(num, factor + 1, cur);
    }

    public static String fractions(String str) {
        Pattern pattern = Pattern.compile("(\\d+).(\\d*)\\((\\d+)\\)");
        Matcher matcher = pattern.matcher(str);

        if (!matcher.find()) return null;

        int ceil = Integer.parseInt(matcher.group(1));
        int fract = Integer.parseInt(matcher.group(2).isEmpty() ?
                "0" : matcher.group(2));

        int top = Integer.parseInt(matcher.group(3));
        int bottom = (int) ((Math.pow(10, matcher.group(3).length()) - 1) *
                Math.pow(10, matcher.group(2).length()));

        top += ceil * bottom;
        top = (int) (top * Math.pow(10, matcher.group(2).length()) +
                fract * bottom);

        bottom *= (int) Math.pow(10, matcher.group(2).length());

        int g = gcd(top, bottom);
        while (g != 1) {
            bottom /= g;
            top /= g;
            g = gcd(top, bottom);
        }

        return top + "/" + bottom;
    }

    public static int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    public static String pilish_string(String str) {
        char[] arr = "314159265358979".toCharArray();
        int curIdx = 0;

        StringBuilder builder = new StringBuilder();

        for (char i : arr) {
            int c = i - 48;
            if (curIdx >= str.length()) {
                break;
            }
            if (curIdx + c >= str.length()) {
                builder.append(str.substring(curIdx))
                        .append(String.valueOf(str.charAt(str.length() - 1))
                                .repeat(c - str.length() + curIdx));
            } else {
                builder.append(str, curIdx, curIdx + c);
            }
            builder.append(' ');
            curIdx += c;
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public static String bgenerateNonconsecutive(String str) {
        Pattern part = Pattern.compile("^( [\\-+*/] )*(\\()*(-*\\d+)(\\))*");
        boolean start = true;
        Node currentNode = new Node("+");
        currentNode.setLeft(new Node("0"));
        int parLevel = 0;

        for (int i = 0; i < str.length();) {
            Matcher matcher = part.matcher(str).region(i, str.length());

            if (!matcher.find()){
                System.out.println("Syntax error");
                return null;
            }

            if (matcher.group(1) == null){
                if (!start){
                    System.out.println("Syntax error");
                    return null;
                }
                currentNode.setRight(new Node(matcher.group(3)));
                start = false;
                i = matcher.end();
                if (!(matcher.group(2) == null)){
                    parLevel++;
                }
                continue;
            }
            Node opNode = new Node(String.valueOf(matcher.group(1).charAt(1)));
            Node numNode = new Node(matcher.group(3));
            opNode.setRight(numNode);
            if (parLevel > 0){
                if (matcher.group(1).charAt(1) == '*' || matcher.group(1).charAt(1) == '/'){
                    opNode.setLeft(currentNode.right);
                    currentNode.setRight(opNode);
                }
                else {
                    opNode.setLeft(currentNode.right);
                    currentNode.setRight(opNode);
                    currentNode = opNode;
                }
            }
            if (parLevel == 0){
                if (matcher.group(1).charAt(1) == '*' || matcher.group(1).charAt(1) == '/'){
                    opNode.setLeft(currentNode.right);

                    currentNode.setRight(opNode);
                }
                else {
                    opNode.setLeft(currentNode);
                    currentNode = opNode;
                }
            }

            if (!(matcher.group(2) == null)){
                currentNode = opNode;
                parLevel++;
            }
            if (!(matcher.group(4) == null)){
                if (!(currentNode.root == null)){
                    currentNode = currentNode.root;
                }
                parLevel--;
            }
            i = matcher.end();
        }
        try {
            double res = currentNode.getUltimateRoot().computeNode();
            if (res % 1 == 0){
                return String.valueOf((int) res);
            }
            return String.valueOf(res);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    static class Node {
        String value;
        Node left;
        Node root;
        Node right;


        public void setLeft(Node node){
            this.left = node;
            node.root = this;
        }

        public void setRight(Node node){
            this.right = node;
            node.root = this;
        }

        public Node getUltimateRoot(){
            if (root != null){
                return root.getUltimateRoot();
            }
            return this;
        }

        public double computeNode() throws Exception {
            if ("+-*/".contains(value)){
                double num1 = left.computeNode();
                double num2 = right.computeNode();

                switch (value){
                    case "+":
                        return num1 + num2;
                    case "-":
                        return num1 - num2;
                    case "*":
                        return num1 * num2;
                    case "/":
                        if (num2 == 0){
                            throw new ArithmeticException("Division by zero");
                        }
                        return num1 / num2;
                    default:
                        throw new Exception("Syntax error");
                }

            }
            return Double.parseDouble(value);
        }

        Node(String value) {
            this.value = value;
            this.root = null;
            right = null;
            left = null;
        }
    }

    public static String isValid(String str){
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()){
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        int bs = 0;
        int norm = -1;

        for (int i : map.values()){
            if (norm == -1){
                norm = i;
                continue;
            }
            if (Math.abs(i - norm) > 1){
                return "NO";
            }
            if (i != norm){
                bs++;
                if (bs > 1){
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static String findLCS(String str1, String str2){
        int[][] arr = getLCS(str1, str2);
        return traceback(arr, str1, str2);
    }

    public static int[][] getLCS(String str1, String str2)
    {
        int[][] arr = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                }
                else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        return arr;
    }

    public static String traceback(int[][] arr, String str1, String str2){
        StringBuilder builder = new StringBuilder();
        int i = str1.length();
        int j = str2.length();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                builder.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            } else if (arr[i - 1][j] > arr[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return builder.toString();
    }
}