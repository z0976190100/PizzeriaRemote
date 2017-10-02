package Logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

        public static void main(String[] args) throws Exception {
            FileRead ff = new FileRead();

            List<String> menu
                    = new ArrayList<>(ff.readByAnchors("Pizzeria.txt",
                    "-menu" , "--menu"));
            System.out.println(menu);

            List<String> order
                    = new ArrayList<>(ff.readByAnchors("Pizzeria.txt",
                    "-orders", "--orders"));
            System.out.println(order);

        }

    }

