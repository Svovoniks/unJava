package lab7;

import java.util.ArrayList;
import java.util.Comparator;

public class Warehouse {
    private ArrayList<Product> stock;
    public Warehouse(ArrayList<Product> stuff){
        this.stock = stuff;
        stuff.sort(Comparator.comparingInt(Product::getWeight).reversed());
    }

    public synchronized Product getProduct(int weight) {
        for(int i = 0; i < stock.size(); i++){
            if (stock.get(i).getWeight() <= weight){
                return stock.remove(i);
            }
        }
        return null;
    }

    public synchronized void addStock(Product p){
        stock.add(p);
    }

    public void transferStock(Loader[] loaders){
        for (Loader loader : loaders){
            loader.getThread().start();
        }
        for (Loader loader : loaders){
            try {
                loader.getThread().join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Product> getStock() {
        return stock;
    }
}
