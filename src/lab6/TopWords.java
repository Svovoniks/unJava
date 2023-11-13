package lab6;

import lab3.HashTable;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class TopWords {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\svovoniks\\Desktop\\file.txt";

        File file = new File(filePath);

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        HashMap<String, Integer> map = new HashMap<>();

        try {
            while (scanner.hasNextLine()){
                scanner.findAll("\\b\\w+\\b").forEach(matchResult ->
                        map.put(matchResult.group().toLowerCase(),
                                map.getOrDefault(matchResult.group().toLowerCase(),
                                        0) + 1));
                scanner.nextLine();
            }
            scanner.close();
        }catch (NullPointerException e){
            System.out.println(e);
        }

        List<Map.Entry<String, Integer>> list = map
                .entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .collect(Collectors.toList());

        for (int i = 0; i < 10 && i < list.size(); i++){
            System.out.println(list.get(i).getKey());
        }
    }
}

