package Logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Dijkstra {

    List<Integer> x = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13));
    List<Integer> y = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13));
    int[][] costIndex = new int[x.size()][y.size()];


    void setCostIndex(List x, List y) {
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
}
