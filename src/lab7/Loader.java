package lab7;

import java.util.ArrayList;

public class Loader implements Runnable{
    private Warehouse warehouse2;
    private Warehouse warehouse1;
    private int totalLoad;
    private final ArrayList<Product> list;
    private Thread thread;
    private final int MAX_LOAD = 150;

    public Loader(Warehouse w1, Warehouse w2){
        warehouse1 = w1;
        warehouse2 = w2;
        thread = new Thread(this);
        totalLoad = 0;
        list = new ArrayList<>();
    }

    private boolean loadUp(){
        Product product = warehouse1.getProduct(MAX_LOAD - totalLoad);
        if (product == null){
            return false;
        }

        while (product != null){
            loadProduct(product);
            product = warehouse1.getProduct(MAX_LOAD - totalLoad);
        }
        return true;
    }

    private void unload(){
        for (Product product : list) {
            warehouse2.addStock(product);
        }
        list.clear();
        totalLoad = 0;
    }

    private void loadProduct(Product p){
        list.add(p);
        totalLoad += p.getWeight();
    }
    @Override
    public void run() {
        while(loadUp()){
            unload();
        }
    }
    public Thread getThread() {
        return thread;
    }
}
