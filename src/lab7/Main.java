package lab7;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<>();
        for (int i = 0; i < 1000000;i++){
            list.add(new Product("je", 12));
        }

        Warehouse warehouse1 = new Warehouse(list);
        Warehouse warehouse2 = new Warehouse(new ArrayList<>());

        Loader[] loaders = {new Loader(warehouse1, warehouse2), new Loader(warehouse1, warehouse2), new Loader(warehouse1, warehouse2)};

        warehouse1.transferStock(loaders);
//
//        warehouse1.getStock().forEach(System.out::println);
//        System.out.println();
//
//        warehouse2.getStock().forEach(System.out::println);
    }
}
