package Logic;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FileRead ff = new FileRead();
        String fileName = "C://Users/admin/OneDrive/codeacademy/IdeaProjects/a-level/PizzeriaGit/Pizzeria/src/Logic/Pizzeria.txt";
       // "C://Users/dell/OneDrive/codeacademy/IdeaProjects/a-level/PizzeriaGit/Pizzeria/src/Logic/Pizzeria.txt";
       /* List<String> menu
                = new ArrayList<>(ff.readByAnchors(fileName, "menu"));
        System.out.println(menu);

        List<String> order
                = new ArrayList<>(ff.readByAnchors(fileName, "orders"));
        System.out.println(order);
*/
        List<String> map
                = new ArrayList<>(ff.readByAnchors(fileName, "map"));
        System.out.println(map);

        CityMap kharkiv = new CityMap(map);
        /*for (Node n : kharkiv.allNodes
                ) {
            System.out.println("Node : " + n.name);
            System.out.println("neighbours : " + n.neighbours);
        }
*/
        String start = "[2";
        String finish = "[9";
        System.out.println("the length of rout " + start + " to " + finish + " is:"
                + kharkiv.getRoute(start, finish));




    }

}

