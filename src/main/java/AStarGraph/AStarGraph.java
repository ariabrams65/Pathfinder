package AStarGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AStarGraph {

    private Map<Node, List<Node>> adjList;
    private List<Edge> edges;

    public AStarGraph() {
        this.adjList = new HashMap<Node, List<Node>>();
        this.edges = new ArrayList<Edge>();
    }

    public void addEdge(Node v, Node u, int weight) {
        if (edges.contains(new Edge(u, v))) {
            throw new IllegalArgumentException();
        }
        if (!adjList.containsKey(v)) {
            adjList.put(v, new LinkedList<Node>());
        }
        if (!adjList.containsKey(u)) {
            adjList.put(u, new LinkedList<Node>());
        }
        adjList.get(v).add(u);
        adjList.get(u).add(v);
        
        edges.add(new Edge(u, v, weight));
    }

    public List<Node> neighbores(Node v) {
        return adjList.get(v);
    }

    public int getEdgeWeight(Node v, Node u) {
        for (Edge e : edges) {
            if (e.getNode1().equals(v) || e.getNode1().equals(u)
                    && e.getNode2().equals(v) || e.getNode2().equals(u)) {
                return e.getWeight();
            }
        }
        throw new IllegalArgumentException();
    }
}
