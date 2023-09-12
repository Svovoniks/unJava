package lab2;

public class Sphere extends GeometricShape{

    protected double radius;
    private static int instanceCount = 0;
    public Sphere(){
        instanceCount++;
        vertexCount = 0;
        edgeCount = 0;
        name = "Sphere";
    }

    public Sphere(double radius){
        this();
        this.radius = radius;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return name + " with radius " + radius;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        instanceCount--;
    }
}

