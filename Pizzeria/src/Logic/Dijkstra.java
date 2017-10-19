package Logic;

import javafx.collections.transformation.SortedList;

import java.util.*;

class Dijkstra {

  /*  List<Integer> x = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13));
    List<Integer> y = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13));
    int[][] costIndex = new int[x.size()][y.size()];
*/
    private List<Integer> finishCosts = new LinkedList<>();

    List <Integer> shortestRouteAlter( Node start, Node finish) {
        if (start.neighbours.containsKey(finish)) {
            //start.visited = true;
            finish.cost = start.cost + start.neighbours.get(finish);
            finishCosts.add(finish.cost);

            return finishCosts;
        }

        Set<Node> nSet = start.neighbours.keySet();

        for (Node startNeighbour : nSet) {
            if (!startNeighbour.visited ) {
                start.visited = true;
                startNeighbour.cost = start.cost + start.neighbours.get(startNeighbour);
                this.shortestRouteAlter(startNeighbour, finish);
            }
        }
        finishCosts.add(9999);
        return finishCosts;
    }


   /* void setCostIndex(List x, List y) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < this.x.size(); i++) {
            for (int j = 1; j < this.y.size(); j++) {
                if (i == j) {
                    this.costIndex[i][j] = -1;
                    continue;
                }
                if (this.costIndex[i][j] == 0) {
                    System.out.println("If the road exist (999 or -1 if not) for nodes [" + x.get(i) + ";" + y.get(j) + "]");
                    int input = sc.nextInt();
                    System.out.println(input);
                    this.costIndex[j][i] = input;
                    this.costIndex[i][j] = input;
                }

            }

        }

    }

    void setAltCostIndex(List x, List y) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input number of roads");
        int roads = sc.nextInt();
        while (0 != roads) {
            System.out.println("input first node");
            int inputX = sc.nextInt();
            System.out.println("input second node");
            int inputY = sc.nextInt();
            System.out.println("distance");
            int dist = sc.nextInt();
            this.costIndex[inputX][inputY] = dist;
            this.costIndex[inputY][inputX] = dist;
            roads--;
        }

    }

    String rout = "";

    int shortestRoute(Node start, Node finish) {
        // cost - length from starting node to THIS node in THIS route
        // Map neighbours is (adjacent node = length from THIS node)
        int[] costing = new int[start.neighbours.size()];// array for sorting costs
        int index = 0;
        System.out.println("now start is " + start.name);

        if (start.neighbours.containsKey(finish)) {
            finish.cost = start.neighbours.get(finish);
            return finish.cost;
        }

        for (Node checkNode : start.neighbours.keySet()) {

            if (checkNode.visited) {
                continue;
            }

            System.out.println("visiting node" + checkNode.name);
            checkNode.cost = start.cost + start.neighbours.get(checkNode);
            System.out.println("setting cost" + checkNode.cost + " for rout from " + start.name);
            checkNode.visited = true;
            shortestRoute(checkNode, finish);
        }
        return finish.cost;
    }

*/


}


