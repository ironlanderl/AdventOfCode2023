package Day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part1 {

    public static int runDay(String[] lines) {
        int value = 0;
        int startIndex = -1, endIndex = -1;
        boolean carattereSpecialeTrovato = false;
        /*
         * How:
         * 1) Loop through lines (line 1)
         * 2) Get start number index and end number index
         * 3) Check between start-1 and end+1, including +1y and -1y
         * 4) Try catch wrap outOfBound
         * */
        for (int nLinea = 0; nLinea < lines.length; nLinea++) {
            if (nLinea == 7) {
                System.out.println("Debugger");
            }
            System.out.println("Next Line");
            /* Loop per le linee */
            /* Adesso divido la linea in un array di chars */
            String[] linea = lines[nLinea].split("");
            for (int nColonna = 0; nColonna < linea.length; nColonna++) {
                if (linea[nColonna].matches("[0-9]") && startIndex == -1) {
                    startIndex = nColonna;
                }
                if ((linea[nColonna].matches("[^0-9]") || nColonna == linea.length - 1) && (endIndex == -1 && startIndex != -1)) {
                    endIndex = nColonna == linea.length - 1 ? nColonna : nColonna - 1;
                }
                if (startIndex != -1 && endIndex != -1) {
                    /* Trovato inizio e fine di una sequenza di numeri */
                    /* Adesso posso cercare se sono presenti simboli non punto */
                    for (int cercaColonna = startIndex - 1; cercaColonna < endIndex + 2; cercaColonna++) {
                        /* Controllo che non esca */
                        if (cercaColonna < 0) cercaColonna = 0;
                        if (cercaColonna >= linea.length) cercaColonna = linea.length - 1;
                        /* Cerco stessa colonna anche nella riga superiore e inferiore */
                        String[] lineaSopra, lineaSotto;
                        if (nLinea > 0) {
                            lineaSopra = lines[nLinea - 1].split("");
                        } else {
                            lineaSopra = new String[200];
                            Arrays.fill(lineaSopra, ".");
                        }
                        if (nLinea < lines.length - 1) {
                            lineaSotto = lines[nLinea + 1].split("");
                        } else {
                            lineaSotto = new String[200];
                            Arrays.fill(lineaSotto, ".");
                        }
                        if (linea[cercaColonna].matches("[^.0-9]") ||
                                lineaSopra[cercaColonna].matches("[^.0-9]") ||
                                lineaSotto[cercaColonna].matches("[^.0-9]")
                        ) {
                            carattereSpecialeTrovato = true;
                            break;
                        }
                    }
                    if (carattereSpecialeTrovato) {
                        /* Trovato carattere speciale, quindi numero è parte */
                        /* Loop per mettere insieme il numero e convertirlo in int */
                        String tmpStringNumero = "";
                        for (int i = startIndex; i < endIndex + 1; i++) {
                            tmpStringNumero += linea[i];
                        }
                        tmpStringNumero = tmpStringNumero.replaceAll("[.]", "");
                        int numeroParte = Integer.parseInt(tmpStringNumero);
                        System.out.println(numeroParte);
                        value += numeroParte;
                        carattereSpecialeTrovato = false;

                    }
                    startIndex = -1;
                    endIndex = -1;
                    //nColonna--;
                }
            }
        }
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
        int result = runDay(lines);
        System.out.println(result);
    }

}
