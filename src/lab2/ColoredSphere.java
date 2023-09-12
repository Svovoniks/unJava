package lab2;

public class ColoredSphere extends Sphere implements Colored{
    private String color;
    public ColoredSphere(){
        super();
    }
    public ColoredSphere(String color){
        this();
        this.color = color;
    }
    public ColoredSphere(double radius, String color){
        super(radius);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColoredSphere{" +
                "color='" + color + '\'' +
                ", radius=" + radius +
                '}';
    }
}
