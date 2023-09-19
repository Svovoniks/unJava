import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println();

        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println();

        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));
        System.out.println();

        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println();

        System.out.println(countRoots(new int[]{1, -3, 2}));
        System.out.println(countRoots(new int[]{2, 5, 2}));
        System.out.println(countRoots(new int[]{1, -6, 9}));
        System.out.println();

        System.out.println(salesData(new String[][]{
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}}));
        System.out.println(salesData(new String[][]{
                {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}}));
        System.out.println();

        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println();

        System.out.println(waveForm(new int[]{3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int []{1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[]{1, 2, -6, 10, 3}));
        System.out.println();

        System.out.println(commonVovel("Hello world") );
        System.out.println(commonVovel("Actions speak louder than words."));
        System.out.println();

        System.out.println(Arrays.deepToString(dataScience(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}})));
        System.out.println(Arrays.deepToString(dataScience(new int[][]{
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}})));
        System.out.println();

    }

    public static String replaceVovels(String str){
        return str.replaceAll("[EUIOAeuioa]", "*");
    }
    public static String stringTransform(String str){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i+1)){
                builder.append("Double").append(str.toUpperCase().charAt(i));
                i++;
            }
            else {
                builder.append(str.charAt(i));
            }
        }
        return builder.toString();
    }
    public static boolean doesBlockFit(int a, int b, int c, int w, int h){
        int[] arr1 = {a, b, c};
        int[] arr2 = {w, h};

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return arr1[0] <= arr2[0] && arr1[1] <= arr2[1];
    }
    public static boolean numCheck(int a){
        int sum = 0;
        String st = String.valueOf(a);
        for (int i = 0; i < st.length(); i++){
            sum += (int) Math.pow(st.charAt(i) - 48, 2);
        }
        return sum%2 == a%2;
    }

    public static int countRoots(int[] arr){
        double d = (arr[1] * arr[1] - 4 * arr[0] * arr[2]);
        if (d < 0){
            return 0;
        }
        double a = (-arr[1] + Math.sqrt(d)) / 2 / arr[0];
        double b = (-arr[1] - Math.sqrt(d)) / 2 / arr[0];

        int count = 0;
        count += (((int) a) == a) ? 1 : 0;
        count += (((int) b) == b) && d != 0 ? 1 : 0;

        return count;
    }
    public static ArrayList<String> salesData(String[][] arr){
        int maxLength = 0;
        ArrayList<String> list = new ArrayList<>();

        for (String[] i : arr){
            if (i.length > maxLength){
                maxLength = i.length;
                list = new ArrayList<>();
                list.add(i[0]);
            }
            else if(i.length == maxLength){
                list.add(i[0]);
            }
        }
        return list;
    }
    public static boolean validSplit(String str){
        String[] arr = str.split(" ");
        for (int i = 1; i < arr.length; i++){
            if (arr[i-1].charAt(arr[i-1].length() - 1) != arr[i].charAt(0)){
                return false;
            }
        }
        return true;
    }
    public static boolean waveForm(int[] arr){
        boolean flag = arr[0] - arr[1] > 0;
        for (int i = 2; i < arr.length; i++){
            if (arr[i-1] - arr[i] > 0 != flag){
                flag = !flag;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static char commonVovel(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        String vowels = "uioa";
        for (Character c : str.toLowerCase().toCharArray()){
            if (!vowels.contains(c.toString())){
                continue;
            }
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }
            else{
                map.put(c, 1);
            }
        }
        int mx = 0;
        char mxC = ' ';
        for (Character c : map.keySet()){
            if (mx < map.get(c)){
                mx = map.get(c);
                mxC = c;
            }
        }
        return mxC;
    }

    public static int[][] dataScience(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            int sum = 0;
            for (int j = 0; j < arr.length; j++){
                if (i == j) continue;
                sum += arr[j][i];
            }
            arr[i][i] = Math.round((float) sum /(arr.length - 1));
        }
        return arr;
    }
}
