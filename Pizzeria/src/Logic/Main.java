package Logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

        }

    }

