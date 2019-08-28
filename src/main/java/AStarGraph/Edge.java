
package AStarGraph;

import java.util.Objects;

public class Edge {
    
    private Node node1;
    private Node node2;
    private int weight;
    
    public Edge(Node node1, Node node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public Edge(Node node1, Node node2) {
        this.node1 = node1;
        this.node2 = node2;
    }
    
    public Node getNode1() {
        return this.node1;
    }
    
    public Node getNode2() {
        return this.node2;
    }
    
    public int getWeight() {
        return this.weight;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.node1);
        hash = 37 * hash + Objects.hashCode(this.node2);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge other = (Edge) obj;
        if (!Objects.equals(this.node1, other.node1)) {
            return false;
        }
        if (!Objects.equals(this.node2, other.node2)) {
            return false;
        }
        return true;
    }
    
    
}
