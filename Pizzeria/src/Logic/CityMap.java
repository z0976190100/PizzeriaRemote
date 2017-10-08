package Logic;

import java.util.*;

public class CityMap {

    // map<String, Integer> 'neighbours' of matches between neighbour nodes and cost of match [node1;node2]=cost
    //map<String, String> 'cityRouts' of routes [node1;node10]=[[node1;node n;node10]=cost]
    //?set for comparing incoming route with existing ones;
    //to calculate cost of incoming rout comparing pairs from 'cityRouts', if not exist, calculate by algorithm

    /*Map<String, Integer> neighbors = new HashMap<>();
    Map<String,String> cityRoutes = new HashMap<>();
    Map<String, String> routCost = new HashMap<>(); */
    List<Node> allNodes = new LinkedList<>();
   /*
    Map getNeighbors (List<String> entry) {

        for (String str : entry) {
           String[] result = str.split(" ");
            System.out.println(result[0]);
            System.out.println(result[1]);
            this.neighbors.put(result[0], Integer.parseInt(result[1]));

        }
        return this.neighbors;
    } */

    CityMap(List<String> nodes) {

        for (String str : nodes) {
            String[] result = str.split(" ");
            this.allNodes.add(new Node(result[0], result[1]));

        }
        for (Node x : this.allNodes
                ) {
            x.setNeighboursSt(this.allNodes);
        }
    }

/*

    int routSeeker(String routeToSeek, Map posRoutes ) {
        int cost;

        String result =(String) posRoutes.get(routeToSeek);
        String []resultInt = result.split("=");
        cost = Integer.parseInt(resultInt[1]);

        return cost;
    }
*/

    int getRoute(String node1, String node2) {
        int lenght = 0;
        for (Node n : this.allNodes
                ) {
            if (n.name.equals(node1)) {
                for (Node d : this.allNodes
                        ) {
                    if (d.name.equals(node2)) {
                        Dijkstra rout = new Dijkstra();
                       lenght = rout.shortestRoute(n, d);
                    }
                }
            }
        }
        return lenght;
    }

}
