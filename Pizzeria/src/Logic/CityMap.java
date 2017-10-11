package Logic;

import java.util.*;

public class CityMap {
    //old version comments- DO NOT READ 'EM!
    // map<String, Integer> 'neighbours' of matches between neighbour nodes and cost of match [node1;node2]=cost
    //map<String, String> 'cityRouts' of routes [node1;node10]=[[node1;node n;node10]=cost]
    //?set for comparing incoming route with existing ones;
    //to calculate cost of incoming rout comparing pairs from 'cityRouts', if not exist, calculate by algorithm


    List<Node> allNodes = new LinkedList<>();


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


    int getRoute(String node1, String node2) {
        int length = 0;
        for (Node n : this.allNodes ) {
            if (n.name.equals(node1)) {
                for (Node d : this.allNodes) {
                    if (d.name.equals(node2)) {
                        Dijkstra rout = new Dijkstra();
                        List<Integer> finishCosts = new LinkedList<>(rout.shortestRouteAlter(n, d));
                        //System.out.println("not sorted : -----------" + finishCosts);
                        Collections.sort(finishCosts);
                        //System.out.println("sorted:   " + finishCosts);
                        length = finishCosts.get(0);
                    }
                }
            }
        }

        return length;
    }

}
