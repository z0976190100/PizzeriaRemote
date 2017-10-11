package Logic;

import java.util.*;

public class Node {

    String name;
    int cost = 0;
    boolean visited;
    String neighboursSt;
    Map<Node, Integer> neighbours = new HashMap<>();
     
    Node(String nam, String neigh) {
        this.name = nam;
        this.visited = false;
        this.neighboursSt = neigh;
    }


    void setNeighboursSt(List<Node> allNod) {
        String[] result = this.neighboursSt.split(";");
        for (String s : result
                ) {
            String[] res = s.split(",");
            for (Node n : allNod
                    ) {
                if (n.name.equals(res[0])) {
                    this.neighbours.put(n, Integer.parseInt(res[1]));
                }

            }
        }
    }

}
