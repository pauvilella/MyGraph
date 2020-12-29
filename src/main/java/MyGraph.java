import java.util.*;

public class MyGraph<T> {
    public ArrayList<MyGraphNode<T>> nodes;

    public MyGraph() {
        nodes = new ArrayList<MyGraphNode<T>>();
    }

    public void DFSPrintNode(MyGraphNode<T> root) {
        if(root == null) {
            return;
        }
        System.out.println("Node " + root.data);
        root.visited = true;
        for (MyGraphNode<T> n : root.adjacents) {
            if(!n.visited) {
                DFSPrintNode(n);
            }
        }
    }

    public void DFSPrint() {
        for (MyGraphNode<T> n : this.nodes) {
            n.marked = false;
            n.visited = false;
        }

        DFSPrintNode(this.nodes.get(0));
    }

    public void BFSPrint() {
        MyQueue<MyGraphNode<T>> q = new MyQueue<MyGraphNode<T>>();
        MyGraphNode<T> root = this.nodes.get(0);
        for (MyGraphNode<T> n : this.nodes) {
            n.marked = false;
            n.visited = false;
        }
        root.marked = true;
        q.add(root);
        while (!q.isEmpty()) {
            MyGraphNode<T> node = q.remove();
            System.out.println("Node " + node.data);
            for (MyGraphNode<T> n : node.adjacents) {
                if(!n.marked) {
                    n.marked = true;
                    q.add(n);
                }
            }
        }
    }

    public static MyGraph<Integer> generateGraph1() {
        MyGraph<Integer> graph = new MyGraph<Integer>();

        //I create all the nodes
        graph.nodes.add(new MyGraphNode<Integer>(0));
        graph.nodes.add(new MyGraphNode<Integer>(1));
        graph.nodes.add(new MyGraphNode<Integer>(2));
        graph.nodes.add(new MyGraphNode<Integer>(3));
        graph.nodes.add(new MyGraphNode<Integer>(4));
        graph.nodes.add(new MyGraphNode<Integer>(5));

        //Set the neighbours of node 0
        graph.nodes.get(0).adjacents.add(graph.nodes.get(1));
        graph.nodes.get(0).adjacents.add(graph.nodes.get(4));
        graph.nodes.get(0).adjacents.add(graph.nodes.get(5));

        //Set the neighbours of node 1
        graph.nodes.get(1).adjacents.add(graph.nodes.get(3));
        graph.nodes.get(1).adjacents.add(graph.nodes.get(4));

        //Set the neighbours of node 2
        graph.nodes.get(2).adjacents.add(graph.nodes.get(1));

        //Set the neighbours of node 3
        graph.nodes.get(3).adjacents.add(graph.nodes.get(2));
        graph.nodes.get(3).adjacents.add(graph.nodes.get(4));

        //Set the neighbours of node 4

        //Set the neighbours of node 5

        return graph;
    }
}
