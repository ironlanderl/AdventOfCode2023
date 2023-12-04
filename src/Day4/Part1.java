package Day4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {
    public static String[] readFile(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new FileInputStream(filename));
            while (scan.hasNextLine()) {
                lines.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String[] tmp = new String[lines.size()];
        return lines.toArray(tmp);
    }

    public static void solveDay(){

    }

    public static void main(String[] args) {
        solveDay();
    }
}
