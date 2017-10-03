package Logic;

import java.util.*;

public class CityMap {

    // map<String, Integer> 'neighbours' of matches between neighbour nodes and cost of match [node1;node2]=cost
    //map<String, String> 'cityRouts' of routes [node1;node10]=[[node1;node n;node10]=cost]
    //?set for comparing incoming route with existing ones;
    //to calculate cost of incoming rout comparing pairs from 'cityRouts', if not exist, calculate by algorithm

    Map<String, Integer> neighbors = new HashMap<>();
    Map<String,String> cityRoutes = new HashMap<>();
    Map<String, String> routCost = new HashMap<>();

    Map getNeighbors (List<String> entry) {

        for (String str : entry) {
           String[] result = str.split(" ");
            System.out.println(result[0]);
            System.out.println(result[1]);
            this.neighbors.put(result[0], Integer.parseInt(result[1]));

        }
        return this.neighbors;
    }

    Map getCityRoutes (List<String> entry) {

        for (String str : entry) {
            String[] result = str.split(" ");
            System.out.println(result[0]);
            System.out.println(result[1]);
            this.cityRoutes.put(result[0], (result[1] + "=" + result[2]));

        }
        return this.cityRoutes;
    }



    int routSeeker(String routeToSeek, Map posRoutes ) {
        int cost;

        String result =(String) posRoutes.get(routeToSeek);
        String []resultInt = result.split("=");
        cost = Integer.parseInt(resultInt[1]);

        return cost;
    }

}
