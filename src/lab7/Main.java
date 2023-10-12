package lab7;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product("name", 12));
        list.add(new Product("name", 13));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 14));
        list.add(new Product("name", 12));
        list.add(new Product("name", 16));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 12));
        list.add(new Product("name", 123));
        list.add(new Product("name", 12233));

        Warehouse warehouse1 = new Warehouse(list);
        Warehouse warehouse2 = new Warehouse(new ArrayList<>());

        Loader[] loaders = {new Loader(warehouse1, warehouse2), new Loader(warehouse1, warehouse2), new Loader(warehouse1, warehouse2)};

        warehouse1.transferStock(loaders);

        warehouse1.getStock().forEach(System.out::println);
        System.out.println();

        warehouse2.getStock().forEach(System.out::println);
    }
}
