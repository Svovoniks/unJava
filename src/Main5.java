import javax.swing.text.DateFormatter;
import java.sql.Timestamp;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main5 {
    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

        System.out.println();

        System.out.println(sameLetterPattern2("ABAB", "CDCD"));
        System.out.println(sameLetterPattern2("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern2("FFGG", "CDCD"));
        System.out.println(sameLetterPattern2("FFFF", "ABCD"));

        System.out.println();

        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));

        System.out.println();

        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));

        System.out.println();

        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));

        System.out.println();

        System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 2, 3, 4, 5}).toArray()));
        System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 2, 3, 7, 9}).toArray()));
        System.out.println(Arrays.deepToString(sumsUp(new int[]{10, 9, 7, 2, 8}).toArray()));
        System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7}).toArray()));

        System.out.println();

        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10%"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));

        System.out.println();

        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4));
        System.out.println(caesarCipher("encode", "almost last task!", 4));

        System.out.println();

        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));

        System.out.println();

        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));

        System.out.println();

        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }

    public static boolean sameLetterPattern(String str1, String str2){
        if (str1.length() != str2.length()){
            return false;
        }

        for (int i = 0; i < str1.length(); i++){
            if (Character.isLetter(str1.charAt(i)) &&
                    Character.isLetter(str2.charAt(i))) {
                str1 = str1.replaceAll(String.valueOf(str1.charAt(i)),
                        Integer.toString(i));
                str2 = str2.replaceAll(String.valueOf(str2.charAt(i)),
                        Integer.toString(i));
            }
        }

        return str1.equals(str2);
    }
    public static boolean sameLetterPattern2(String str1, String str2){
        if (str1.length() != str2.length()){
            return false;
        }

        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();

        for (int i = 0; i < str1.length() - 1; i++){
            builder1.append(str1.charAt(i) - str1.charAt(i+1));
            builder2.append(str2.charAt(i) - str2.charAt(i+1));
        }

        return builder1.compareTo(builder2) == 0;
    }
    public static String spiderVsFly(String str1, String str2){

        int circleDif = Math.abs(str1.charAt(0) - str2.charAt(0));

        int walk = 1;

        if (circleDif > 8 - circleDif){
            circleDif = 8 - circleDif;
            walk = -1;
        }

        int spiderHeight = Character.getNumericValue(str1.charAt(1));
        int flyHeight = Character.getNumericValue(str2.charAt(1));

        double minLen = 100000;

        int minI = 0;

        for (int i = 0; i < 5; i++){
            double len = (Math.abs(spiderHeight - i)
                    + Math.abs(flyHeight - i)
            );

            len += circleDif * Math.sqrt(i*i*2 - 2*i*i*Math.cos(Math.toRadians(45)));

            if (len < minLen) {
                minLen = len;
                minI = i;
            }
        }

        StringBuilder path = new StringBuilder();

        int spiderMove = minI > spiderHeight ? 1 : -1;

        for (int i = spiderHeight; i != minI + spiderMove; i += spiderMove){
            if (i == 0){
                path.append('A');
            }
            else {
                path.append(str1.charAt(0));
            }

            path.append(i).append('-');
        }

        if (minI != 0){
            for (int i = 0; i < circleDif; i++){
                path.append(Character.toString(path.charAt(path.length() - 3) + walk))
                        .append(minI).append('-');
            }
        }

        int flyMove = minI > flyHeight ? -1 : 1;

        for (int i = minI + flyMove; i != flyHeight + flyMove; i += flyMove){

            path.append(str2.charAt(0));
            path.append(i).append('-');
        }

        path.deleteCharAt(path.length()-1);

        return path.toString();
    }

    public static int digitsCount(long i){
        return i/10 != 0 ?  1 + digitsCount(i/10) : 1;
    }
    public static int totalPoints(String[] arr, String word){
        HashMap<Character, Integer> wordMap = toMap(word);

        int points = 0;

        for (String str : arr){
            HashMap<Character, Integer> map = toMap(str);
            boolean allGood = true;
            for (char c : map.keySet()){
                if (wordMap.containsKey(c) && wordMap.get(c) >= map.get(c)){
                    continue;
                }
                allGood = false;
                break;
            }

            if (allGood){
                points += Math.max(str.length() - 2, 0);
                if (str.length() == 6){
                    points += 50;
                }
            }
        }

        return points;
    }

    public static HashMap<Character, Integer> toMap(String word){
        HashMap<Character, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++){
            wordMap.putIfAbsent(word.charAt(i), 0);
            wordMap.put(word.charAt(i), wordMap.get(word.charAt(i)) + 1);
        }
        return wordMap;
    }

    public static ArrayList<int[]> sumsUp(int[] arr){
        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < i; j++){
                if (arr[i] + arr[j] == 8){
                    int[] t = new int[]{arr[i], arr[j]};
                    Arrays.sort(t);
                    result.add(t);
                }
            }
        }

        return result;
    }

    public static String takeDownAverage(String[] arr){
        int curAvr = 0;

        for (String s : arr){
            curAvr += Integer.parseInt(s.replace("%" ,""));
        }

        curAvr/=arr.length;

        return curAvr-(5*(arr.length + 1)) + "%";
    }

    public static String caesarCipher(String key, String message, int shift){
        if (key.equals("decode")){
            shift = -shift;
        }

        message = message.toUpperCase();
        StringBuilder builder = new StringBuilder();

        for (char i : message.toCharArray()){
            char t = i;
            if (i < 'Z' && i > 'A'){
                t = encode(i, shift);
            }
            builder.append(t);
        }

        return builder.toString();
    }

    public static char encode(char i, int shift){
        i = Character.toUpperCase(i);
        int prim = i+shift;
        if (prim > 'Z'){
            prim = prim - 'Z' + 'A';
        }
        if (prim < 'A'){
            prim = 'Z' - (prim - 'A');
        }
        return (char) prim;
    }
    public static int setSetup(int n, int k){
        if (n == 1){
            return 1;
        }

        double res =  ((double) n /(n-k)) * setSetup(n-1, (n-k) < 2 ? n - 2 : k);
        return (int) res;
    }

    public static String timeDifference(String city, String timeStr, String city2){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm");
        ZonedDateTime time = ZonedDateTime
                .parse(timeStr, formatter.withZone(getZoneID(city)));

        return time.withZoneSameInstant(getZoneID(city2))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public static ZoneId getZoneID(String str){
        HashMap<String, String> map = new HashMap<>();
        map.put("Los Angeles", "America/Los_Angeles");
        map.put("New York", "America/New_York");
        map.put("Caracas", "America/Caracas");
        map.put("Buenos Aires", "America/Argentina/Buenos_Aires");
        map.put("London", "Europe/London");
        map.put("New Delhi", "Asia/Calcutta");
        map.put("Rome", "Europe/Rome");
        map.put("Moscow", "Europe/Moscow");
        map.put("Tehran", "Asia/Tehran");
        map.put("Beijing", "Asia/Shanghai");
        map.put("Canberra", "Australia/Canberra");

        return ZoneId.of(str, map);
    }


    public static boolean isNew(int num){
        char[] arr = String.valueOf(num).toCharArray();

        Arrays.sort(arr);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] - '0' == 0 && builder.length() == 0){
                for (; i < arr.length; i++){
                    if (arr[i] - '0' == 0){
                        builder.append(arr[i]);
                        continue;
                    }
                    break;
                }
                if (i < arr.length){
                    builder.insert(0, arr[i]);
                }
            }
            else {
                builder.append(arr[i]);
            }
        }
        return builder.toString().equals(String.valueOf(num));
    }

}

