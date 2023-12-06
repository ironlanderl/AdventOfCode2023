package Day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D3 {

    public static int runPart1(String[] lines) {
        int value = 0;
        boolean charFound = false;
        int startIndex = -1, endIndex = -1;
        Grid2D<String> grid = new Grid2D<>();

        /* Parse into a Grid2D */
        for (String line : lines) {
            grid.addLine(new ArrayList<>(List.of(line.split(""))));
        }

        for (int y = 0; y < grid.getNumRows(); y++) {
            for (int x = 0; x < grid.getNumColumns(y); x++) {
                /* Keep looping and checking for start and end of number */
                if (grid.getElement(y, x).matches("[0-9]") && startIndex == -1) {
                    startIndex = x;
                }
                if ((grid.getElement(y, x).matches("[^0-9]") || x == grid.getNumColumns(y) - 1) && (endIndex == -1 && startIndex != -1)) {
                    endIndex = x == grid.getNumColumns(y) - 1 ? x : x - 1;
                    // endIndex = x;
                }

                /* Sequenza di numeri trovata */
                if (startIndex != -1 && endIndex != -1) {
                    for (int i = startIndex; i < endIndex + 1; i++) {
                        for (String ch : grid.getNeighbors(y, i)) {
                            if (ch != null && ch.matches("[^.0-9]")) {
                                charFound = true;
                            }
                        }
                    }
                    if (charFound) {
                        String tmpStringNumero = "";
                        for (int i = startIndex; i < endIndex + 1; i++) {
                            tmpStringNumero += grid.getElement(y, i);
                        }
                        tmpStringNumero = tmpStringNumero.replaceAll("[.]", "");
                        int numeroParte = Integer.parseInt(tmpStringNumero);
                        // System.out.println(numeroParte);
                        value += numeroParte;
                        charFound = false;
                    }
                    startIndex = -1;
                    endIndex = -1;
                }
            }
            // System.exit(69420);
        }

        //System.out.println(grid);

        return value;
    }

    public static int runPart2(String[] lines) {
        int value = 0;
        boolean charFound = false;
        int startIndex = -1, endIndex = -1;
        Grid2D<String> grid = new Grid2D<>();

        /* Parse into a Grid2D */
        for (String line : lines) {
            grid.addLine(new ArrayList<>(List.of(line.split(""))));
        }

        for (int y = 0; y < grid.getNumRows(); y++) {
            for (int x = 0; x < grid.getNumColumns(y); x++) {
                /* Keep looping and checking for start and end of number */
                if (grid.getElement(y, x).matches("[0-9]") && startIndex == -1) {
                    startIndex = x;
                }
                if ((grid.getElement(y, x).matches("[^0-9]") || x == grid.getNumColumns(y) - 1) && (endIndex == -1 && startIndex != -1)) {
                    endIndex = x == grid.getNumColumns(y) - 1 ? x : x - 1;
                    // endIndex = x;
                }

                /* Sequenza di numeri trovata */
                if (startIndex != -1 && endIndex != -1) {
                    for (int i = startIndex; i < endIndex + 1; i++) {
                        for (String ch : grid.getNeighbors(y, i)) {
                            if (ch != null && ch.matches("[^.0-9]")) {
                                charFound = true;
                            }
                        }
                    }
                    if (charFound) {
                        String tmpStringNumero = "";
                        for (int i = startIndex; i < endIndex + 1; i++) {
                            tmpStringNumero += grid.getElement(y, i);
                        }
                        tmpStringNumero = tmpStringNumero.replaceAll("[.]", "");
                        int numeroParte = Integer.parseInt(tmpStringNumero);
                        // System.out.println(numeroParte);
                        value += numeroParte;
                        charFound = false;
                    }
                    startIndex = -1;
                    endIndex = -1;
                }
            }
            // System.exit(69420);
        }

        //System.out.println(grid);

        return value;
    }


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

    public static void main(String[] args) {
        String[] lines = readFile("./src/Day3/input.txt");
        int result = runPart1(lines);
        System.out.println("Part 1 : " + result);
    }

}
