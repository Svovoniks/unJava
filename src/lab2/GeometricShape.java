package lab2;

public abstract class GeometricShape{
    protected String name;
    protected int edgeCount;
    protected int vertexCount;

    public String getName(){
        return name;
    }

    public int getEdgeCount(){
        return edgeCount;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    @Override
    public String toString() {
        return name;
    }
}

