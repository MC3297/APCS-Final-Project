import java.util.*;
public class Graph {
    //Adjacency list
    public Map<Integer, ArrayList<Integer>> adj;
    public Graph() {
        adj = new HashMap<>();
    }
    //Adds bidirectional edge to adjacency list
    public void addUndirectedEdge(int a, int b) {
        if (!adj.containsKey(a)) {
            adj.put(a, new ArrayList<>());
        }
        if (!adj.containsKey(b)) {
            adj.put(b, new ArrayList<>());
        }
        adj.get(a).add(b);
        adj.get(b).add(a);
    }
}