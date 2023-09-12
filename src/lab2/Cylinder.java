package lab2;

public class Cylinder extends GeometricShape{
    private double radius;
    private double height;

    public Cylinder(){
        name = "Cylinder";
        vertexCount = 0;
        edgeCount = 2;
    }

    public Cylinder(double height, double radius){
        this();
        this.height = height;
        this.radius = radius;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
