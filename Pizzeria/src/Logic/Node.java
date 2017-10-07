package Logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {

    String name;
    int cost;
    int roadLength;
    boolean visited;
    Map<Node, Integer> neighbours = new HashMap<>();

    Node(String nam, int roadLeng){
        this.name = nam;
        this.roadLength = roadLeng;
        this.visited = false;
    }

    void setCost(int cos){
        this.cost = cos;
    }

    void setNeighbours(Node neigh, int leng) {
        this.neighbours.put(neigh, leng);
    }

}
