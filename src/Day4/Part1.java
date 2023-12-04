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

    public static int solvePart1(String filePath) {
        int points = 0;
        ArrayList<Card> cards = new ArrayList<>();
        String[] cardsStr = readFile(filePath);
        /* Remove the card index, keeping only the numbers */
        for (int i = 0; i < cardsStr.length; i++) {
            cardsStr[i] = cardsStr[i].replaceFirst("Card[ ]+[0-9]+:", "");
        }
        /* Convert to Card Object */
        for (String str : cardsStr) {
            cards.add(new Card(str));
        }

        for (Card card : cards) {
            points += card.getPoints();
        }

        return points;
    }

    public static int solvePart2(String filePath) {
        int totalCards = 0;
        ArrayList<Card> cards = new ArrayList<>();
        String[] cardsStr = readFile(filePath);
        /* Remove the card index, keeping only the numbers */
        for (int i = 0; i < cardsStr.length; i++) {
            cardsStr[i] = cardsStr[i].replaceFirst("Card[ ]+[0-9]+:", "");
        }
        /* Convert to Card Object */
        for (String str : cardsStr) {
            cards.add(new Card(str));
        }

        /* Calculate card moleplicity */
        for (int i = 0; i < cards.size(); i++) {
            int cardWinning = cards.get(i).getPresences();
            while (cardWinning > 0) {
                try {
                    cards.get(i + cardWinning).molteplicita =
                            (cards.get(i + cardWinning).molteplicita) + (cards.get(i).molteplicita);

                } catch (IndexOutOfBoundsException ignored) {}
                cardWinning--;
            }
        }

        /* Count cards */
        for( Card card :cards){
            totalCards += card.molteplicita;
        }

        return totalCards;
    }

    public static void main(String[] args) {
        int points = solvePart1("src/Day4/input.txt");
        System.out.println("Part1 : " + points);
        int numCards = solvePart2("src/Day4/input.txt");
        System.out.println("Part2 : " + numCards);
    }
}
