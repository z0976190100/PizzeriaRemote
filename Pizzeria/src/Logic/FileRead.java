package Logic;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRead {



    public static void myFileWriter(String fileName, String userInput) throws Exception {

        try (FileWriter fw = new FileWriter(fileName, false)) {
            fw.write(userInput);
            fw.close();

        } catch (IOException ex) {
            System.out.println("OOOOOpS!" + ex.getMessage());
        }
    }

    public static String myFileReader(String fileName) throws Exception {

        try (FileReader fr = new FileReader(fileName)) {

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        FileReader fr = new FileReader(fileName);
        Scanner read = new Scanner(fr);
        String gotcha = read.nextLine();
        fr.close();
        return gotcha;

    }

                                                                        //method reads menu text from file
    public List<String> readMenu(String fileName) throws Exception {

        try (FileReader fr = new FileReader(fileName)) {

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        FileReader fr = new FileReader(fileName);
        Scanner read = new Scanner(fr);
        List<String> gotcha = new ArrayList<>();
        String rr = read.nextLine();
        while (!rr.equals("-menu")){
            rr = read.nextLine();
        }
        while (!rr.equals("--menu")) {
            rr = read.nextLine();
            if(rr.equals("--menu")) break;
            gotcha.add(rr);
        }

        fr.close();
        return gotcha;
    }

    public List<String> readOrder(String fileName) throws Exception {

        try (FileReader fr = new FileReader(fileName)) {

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        FileReader fr = new FileReader(fileName);
        Scanner read = new Scanner(fr);
        List<String> gotcha = new ArrayList<>();
        String rr = read.nextLine();

        while (!rr.equals("-orders")){
            rr = read.nextLine();
        }
        while (!rr.equals("--orders")) {
            rr = read.nextLine();
            if(rr.equals("--orders")) break;
            gotcha.add(rr);
        }

        fr.close();
        return gotcha;
    }
}




