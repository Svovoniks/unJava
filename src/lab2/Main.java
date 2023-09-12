package lab2;

public class Main {
    public static void main(String[] args) {
        System.out.println(Sphere.getInstanceCount());
        Sphere sphere = new Sphere();

        System.out.println(Sphere.getInstanceCount());
        sphere = null;

        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.gc();
            System.out.println(Sphere.getInstanceCount());
        }
    }
}