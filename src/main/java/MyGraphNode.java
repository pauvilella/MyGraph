import java.util.*;

public class MyGraphNode<T> {
    public T data;
    public ArrayList<MyGraphNode<T>> adjacents;
    public boolean visited;
    public boolean marked;

    public MyGraphNode(T data) {
        this.data = data;
        adjacents = new ArrayList<MyGraphNode<T>>();
        visited = false;
        marked = false;
    }

}
