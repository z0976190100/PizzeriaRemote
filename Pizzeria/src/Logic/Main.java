package Logic;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FileRead ff = new FileRead();
        String fileName = "C://Users/admin/OneDrive/codeacademy/IdeaProjects/a-level/PizzeriaGit/Pizzeria/src/Logic/Pizzeria.txt";

        List<String> menu
                = new ArrayList<>(ff.readByAnchors(fileName, "menu"));
        System.out.println(menu);

        List<String> order
                = new ArrayList<>(ff.readByAnchors(fileName, "orders"));
        System.out.println(order);

        List<String> map
                = new ArrayList<>(ff.readByAnchors(fileName, "map"));
        System.out.println(map);

        CityMap kharkiv = new CityMap(map);
        for (Node n: kharkiv.allNodes
             ) {
            System.out.println("Node : " + n.name);
            System.out.println("neighbours : " + n.neighbours);
        }


        System.out.println(kharkiv.getRoute("[5", "[7"));

       // List<String> routes
          //      = new ArrayList<>(ff.readByAnchors(fileName, "routes"));
      //  System.out.println("list of possible routes: \n" + routes);

       // CityMap first = new CityMap();

      /*  Map firstNeighbors;
        firstNeighbors = first.getNeighbors(map);
        System.out.println(firstNeighbors.keySet());

        Map firstCityRoutes;
        firstCityRoutes = first.getCityRoutes(routes);
        System.out.println(firstCityRoutes);

        


        System.out.println(first.routSeeker("[5;3]", first.cityRoutes));

        Dijkstra dijkstra1 = new Dijkstra();
        dijkstra1.setAltCostIndex(dijkstra1.x, dijkstra1.y);

*/


    }

}

