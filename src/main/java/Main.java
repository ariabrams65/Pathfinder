
import AStar.AStarPathFinder;
import AStarGraph.AStarGraph;
import AStarGraph.Node;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<Node>();
        
                                                        // s
        nodes.add(new Node(0, 0, "0"));                 //[0 ][1 ][2 ][3 ]     s = start
        nodes.add(new Node(10, 0, "1"));                //[4 ][5 ][# ][6 ]     f = finish
        nodes.add(new Node(20, 0, "2"));                //[12][# ][# ][7 ]     # = wall
        nodes.add(new Node(30, 0, "3"));                //[8 ][9 ][10][11]
        nodes.add(new Node(0, 10, "4"));                //          f
        nodes.add(new Node(10, 10, "5"));               
        nodes.add(new Node(30, 10, "6"));               
        nodes.add(new Node(30, 20, "7"));
        nodes.add(new Node(0, 30, "8"));
        nodes.add(new Node(10, 30, "9"));
        nodes.add(new Node(20, 30, "10"));
        nodes.add(new Node(30, 30, "11"));
        nodes.add(new Node(0, 20, "12"));
        
        AStarGraph graph = new AStarGraph(nodes.get(0), nodes.get(10));

        graph.addEdge(nodes.get(0), nodes.get(4), 10);
        graph.addEdge(nodes.get(0), nodes.get(5), 14);
        graph.addEdge(nodes.get(0), nodes.get(1), 10);
        graph.addEdge(nodes.get(1), nodes.get(5), 10);
        graph.addEdge(nodes.get(5), nodes.get(2), 14);
        graph.addEdge(nodes.get(1), nodes.get(2), 10);
        graph.addEdge(nodes.get(2), nodes.get(3), 10);
        graph.addEdge(nodes.get(2), nodes.get(6), 14);
        graph.addEdge(nodes.get(3), nodes.get(6), 10);
        graph.addEdge(nodes.get(6), nodes.get(7), 10);
        graph.addEdge(nodes.get(7), nodes.get(11), 10);
        graph.addEdge(nodes.get(7), nodes.get(10), 14);
        graph.addEdge(nodes.get(11), nodes.get(10), 10);
        graph.addEdge(nodes.get(10), nodes.get(9), 10);
        graph.addEdge(nodes.get(9), nodes.get(8), 10);
        graph.addEdge(nodes.get(4), nodes.get(12), 10);
        graph.addEdge(nodes.get(12), nodes.get(8), 10);
        graph.addEdge(nodes.get(12), nodes.get(9), 14);
        graph.addEdge(nodes.get(4), nodes.get(5), 10);

        AStarPathFinder alg = new AStarPathFinder(graph);
        for (Node n : alg.getPath()) {
            System.out.println(n);
            }
        }

    }
