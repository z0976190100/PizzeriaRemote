package Logic;

import java.util.*;

import static Logic.FileRead.readByAnchors;
import static Logic.OrderManager.orderDone;

public class Main {

    public static void main(String[] args) throws Exception {

        String fileName = //"C://Users/admin/OneDrive/codeacademy/IdeaProjects/a-level/PizzeriaGit/Pizzeria/src/Logic/Pizzeria.txt";
        "C://Users/dell/OneDrive/codeacademy/IdeaProjects/a-level/PizzeriaGit/Pizzeria/src/Logic/Pizzeria.txt";
        List<String> map
                = new ArrayList<>(/*Arrays.asList("[1 [2,3;[6,7", "[2 [5,4;[1,3", "[3 [5,4;[9,6", "[4 [5,10",
                "[5 [7,5;[3,4;[4,10;[2,4", "[6 [10,5;[1,7", "[7 [5,5;[10,7;[8,4", "[8 [7,4;[9,7", "[9 [3,6;[8,7", "[10 [6,5;[7,7"));*/
                readByAnchors(fileName, "map"));

        List<String> order
                = new ArrayList<>(readByAnchors(fileName, "orders"));
        //System.err.println(order);

        OrderManager man = new OrderManager();

        man.couriersHiring();
        CityMap kh = new CityMap(map);
        //System.out.println(couriersTable);
         System.err.println(man.throwsOrder(order)) ;

        System.err.println("++"+ orderDone);

 /*String start = "[2";
        String finish = "[7";
        System.out.println("the length of rout " + start + " to " + finish + " is:"
                + kharkiv.getRoute(start, finish));*/


    }



}

