package Logic;

import java.io.IOException;
import java.util.*;

public class Main {

        public static void main(String[] args) throws Exception {
            FileRead ff = new FileRead();
String fileName = "C://Users/admin/OneDrive/codeacademy/IdeaProjects/a-level/PizzeriaGit/Pizzeria/src/Logic/Pizzeria.txt";
            List<String> menu
                    = new ArrayList<>(ff.readByAnchors(fileName,
                    "-menu" , "--menu"));
            System.out.println(menu);

            List<String> order
                    = new ArrayList<>(ff.readByAnchors(fileName,
                    "-orders", "--orders"));
            System.out.println(order);

            List<String> map
                    = new ArrayList<>(ff.readByAnchors(fileName,
                    "-map", "--map"));
            System.out.println(map);

            Dijkstra first  = new Dijkstra();
            Map firstNeighbors;
            firstNeighbors = first.getNeighbors(map);
            System.out.println(firstNeighbors.keySet());




        }

    }

