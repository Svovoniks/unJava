package lab8;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        DataManager manager = new DataManager();

        try (FileWriter writer = new FileWriter("C:\\Users\\svovoniks\\Desktop\\New Text Document.txt")){
            for (int i = 0; i < 12422343; i++){
                writer.write(i + "\n");
            }
        } catch (IOException e) {
            System.out.println("error");
        }

        manager.loadData("C:\\Users\\svovoniks\\Desktop\\New Text Document.txt");

        manager.registerDataProcessor(new DataFilter((a) -> a.startsWith("1")));
        manager.registerDataProcessor(new DataSorter(String::compareTo));

        manager.processData();

        manager.saveData("C:\\Users\\svovoniks\\Desktop\\New Text Document2.txt");
    }
}


