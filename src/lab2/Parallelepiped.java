package lab2;

public class Parallelepiped extends GeometricShape {
    protected double x;
    protected double y;
    protected double z;

    public Parallelepiped() {
        vertexCount = 8;
        edgeCount = 12;
        name = "Parallelepiped";
    }

    public Parallelepiped(double x, double y, double z) {
        this();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Parallelepiped{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}

