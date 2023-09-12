package lab2;

public class ColoredParallelepiped extends Parallelepiped implements Colored{
    private String color;

    public ColoredParallelepiped(){
        super();
    }

    public ColoredParallelepiped(String color){
        this();
        this.color = color;
    }

    public ColoredParallelepiped(double x, double y, double z, String color){
        super(x, y, z);
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColoredParallelepiped{" +
                "color='" + color + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
