package Day1;

import org.apache.commons.lang3.ArrayUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        int sum = 0;
        String concatNumbers;
        try {
            Scanner scan = new Scanner(new FileInputStream("./src/Day1/part1.txt"));
            while (scan.hasNextLine()){
                String line = scan.nextLine();
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
                System.out.println(sum);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
