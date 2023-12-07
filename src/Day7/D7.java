package Day7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class D7 {
    public static long solvePart1(ArrayList<Hand> hands){
        long result = 0;
        hands.sort(Collections.reverseOrder());

        for(int i = 0; i < hands.size(); i++){
            result += (long) hands.get(i).getBid() * (i + 1);
        }

        return result;
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

    public static ArrayList<Hand> parser(String[] lines){
        ArrayList<Hand> hands = new ArrayList<>();

        for (String line : lines){
            String[] handString = line.split(" ");
            Hand hand = new Hand(Integer.parseInt(handString[1]));
            String[] card = handString[0].split("");
            for(String str : card){
                hand.addCard(Card.stringToCard(str));
            }
            hands.add(hand);
        }

        return hands;
    }

    public static void main(String[] args) {
        String[] lines = readFile("src/Day7/input.txt");
        long res1 = solvePart1(parser(lines));
        System.out.println("Part 1: " + res1);
    }
}
