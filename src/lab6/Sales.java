package lab6;

import java.util.*;

public class Sales {

    static class Sale{
        private String name;
        private int price;
        private int count;
        private Sale(String name, int price, int count){
            this.name = name;
            this.count = count;
            this.price = price;
        }

        public int getCount() {
            return count;
        }

        public int getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Sale: " + name + "\nAmount: " + count + "\nPrice:" + price + "\n";
        }
    }

    private ArrayList<Sale> sales;
    private HashMap<String, Sale> topSales;
    private int totalRevenue;
    private int totalItemsSold;

    public Sales(){
        sales = new ArrayList<>();
        topSales = new HashMap<>();
        totalRevenue = 0;
        totalItemsSold = 0;
    }

    public void addSale(String name, int price, int count){
        sales.add(new Sale(name, price, count));

        totalRevenue += price * count;
        totalItemsSold += count;

        topSales.putIfAbsent(name, new Sale(name, price, 0));
        topSales.get(name).count += count;
    }

    public int getTotalRevenue(){
        return totalRevenue;
    }

    public int getTotalItemsSold() {
        return totalItemsSold;
    }

    public void printAllSales(){
        sales.forEach(System.out::println);
    }

    public Sale getTopItem(){
        return Collections.max(topSales.entrySet(),
                Comparator.comparingInt(value -> value.getValue().count)).getValue();
    }
}
