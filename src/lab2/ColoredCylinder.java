package lab2;

public class ColoredCylinder extends Cylinder implements Colored{

    private String color;

    public ColoredCylinder(){
        super();
    }

    public ColoredCylinder(String color){
        this();
        this.color = color;
    }

    public ColoredCylinder(double height, double radius, String color){
        super(height, radius);
        this.color = color;
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
