
package AStar;

import AStarGraph.AStarGraph;
import AStarGraph.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AStarPathFinder {
    
    private AStarGraph graph;
    private Node start;
    private Node end;
    
    public AStarPathFinder(AStarGraph graph, Node start, Node end) {
        this.graph = graph;
        this.start = start;
        this.end = end;
    }
    
    public List<Node> getPath() {
        List<Node> open = new ArrayList<Node>();
        List<Node> closed = new ArrayList<Node>();
        
        start.setG(0);
        start.setF(0);
        open.add(start);
        
        while(true) {
            Node current = lowestF(open);
            open.remove(current);
            closed.add(current);
            
            if (current.equals(end)) {
                break;
            }
            for (Node node : graph.neighbores(current)) {
                
                if (closed.contains(node)) {
                    continue;
                }
                int newG = current.getG() + graph.getEdgeWeight(current, node);
                
                if (newG < node.getG() || !open.contains(node)) {
                    node.setF(newG + distance(node, end));
                    node.setG(newG);
                    
                    node.setParent(current);
                    
                    if (!open.contains(node)) {
                        open.add(node);
                    }
                }
            }
        }
        return backtrace();
    }

    private Node lowestF(List<Node> open) {
        Node lowest = open.get(0);
        
        for (Node n : open) {
            if (n.getF() < lowest.getF()) {
                lowest = n;
            }
        }
        return lowest; 
    }

    private int distance(Node v, Node u) {
        return Math.abs(u.getX() - v.getX()) + Math.abs(u.getY() - v.getY());
    }

    private List<Node> backtrace() {
       List<Node> path = new ArrayList<Node>();
       Node current = end;
       path.add(current);
       
       while(current != start) {
           current = current.getParent();
           path.add(current);        
       }
       Collections.reverse(path);
       return path;
    }
}
