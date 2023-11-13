package lab7;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<>();
        for (int i = 0; i < 100000;i++){
            list.add(new Product("je", 10));
        }

        Warehouse warehouse1 = new Warehouse(list);
        Warehouse warehouse2 = new Warehouse(new ArrayList<>());

        System.out.println(warehouse1.getStock().size());
        System.out.println(warehouse2.getStock().size());

        Loader[] loaders = new Loader[10];

        for (int i = 0; i < loaders.length; i++){
            loaders[i] = new Loader(warehouse1, warehouse2);
        }
        warehouse1.transferStock(loaders);

        System.out.println();

        System.out.println(warehouse1.getStock().size());
        System.out.println(warehouse2.getStock().size());
    }
}
