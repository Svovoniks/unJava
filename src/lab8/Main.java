package lab8;

import java.util.Comparator;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        DataManager manager = new DataManager();
        manager.loadData("C:\\Users\\svovoniks\\Desktop\\New Text Document.txt");

        manager.registerDataProcessor(new DataFilter((a) -> a.startsWith("l")));
        manager.registerDataProcessor(new DataSorter(String::compareTo));

        manager.processData();

        manager.saveData("C:\\Users\\svovoniks\\Desktop\\New Text Document2.txt");
    }
}


