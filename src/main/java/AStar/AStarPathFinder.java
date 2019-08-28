
package AStar;

import AStarGraph.AStarGraph;
import AStarGraph.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AStarPathFinder {
    
    private AStarGraph graph;
    
    public AStarPathFinder(AStarGraph graph) {
        this.graph = graph;
    }
    
    public List<Node> getPath() {
        List<Node> open = new ArrayList<Node>();
        List<Node> closed = new ArrayList<Node>();
        
        graph.getStart().setG(0);
        graph.getStart().setF(0);
        open.add(graph.getStart());
        
        while(true) {
            Node current = lowestF(open);
            System.out.println(current + " " + graph.getEnd());
            open.remove(current);
            closed.add(current);
            
            if (current.equals(graph.getEnd())) {
                break;
            }
            for (Node node : graph.neighbores(current)) {
                
                if (closed.contains(node)) {
                    continue;
                }
                int newG = current.getG() + graph.getEdgeWeight(current, node);
                
                if (newG < node.getG() || !open.contains(node)) {
                    node.setF(newG + distance(node, graph.getEnd()));
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
       Node current = graph.getEnd();
       
       while(true) {
           path.add(current);
           current = current.getParent();
           if (current == graph.getStart()) {
               break;
           }
       }
       Collections.reverse(path);
       return path;
    }
}
