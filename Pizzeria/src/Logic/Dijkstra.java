package Logic;

import java.util.*;

public class Dijkstra {

    // map<String, Integer> 'neighbours' of matches between neighbour nodes and cost of match [node1;node2]=cost
    //map<String, map<String, Integer> 'cityRouts' of routes [node1;node10]=[[node1;node n;node10]=cost]
    //?set for comparing incoming route with existing ones;
    //to calculate cost of incoming rout comparing pairs from 'cityRouts', if not exist, calculate by algorithm

    Map<String, Integer> neighbors = new HashMap<>();

    Map getNeighbors (List<String> entry) {

        for (String str : entry) {
           String[] result = str.split(" ");
            System.out.println(result[0]);
            System.out.println(result[1]);
            this.neighbors.put(result[0], Integer.parseInt(result[1]));

        }

        return this.neighbors;
    }


}
