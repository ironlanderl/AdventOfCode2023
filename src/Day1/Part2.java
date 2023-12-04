package Day1;

import org.apache.commons.lang3.ArrayUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {

    public static String replaceNumberString(String input){
        return input
                .replaceAll("one", "o1e")
                .replaceAll("two", "t2o")
                .replaceAll("three", "thr3e")
                .replaceAll("four", "fo4re")
                .replaceAll("five", "fi5e")
                .replaceAll("six", "s6x")
                .replaceAll("seven", "s7ven")
                .replaceAll("eight", "ei8ht")
                .replaceAll("nine", "ni9e");
    }

    public static void main(String[] args) {
        int sum = 0;
        String concatNumbers;
        try {
            Scanner scan = new Scanner(new FileInputStream("./src/Day1/part1.txt"));
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                line = replaceNumberString(line);
                concatNumbers = "";
                String[] chars = line.split("");
                for (String c: chars){
                    try{
                        Integer.parseInt(c);
                        concatNumbers += c;
                        break;
                    }
                    catch (NumberFormatException ignored){}
                }

                ArrayUtils.reverse(chars);

                for (String c: chars){
                    try{
                        Integer.parseInt(c);
                        concatNumbers += c;
                        break;
                    }
                    catch (NumberFormatException ignored){}
                }
                sum += Integer.parseInt(concatNumbers);
                System.out.println(concatNumbers);
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
