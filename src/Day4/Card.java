package Day4;

import java.util.ArrayList;

public class Card {
    ArrayList<Integer> winningNumbers = new ArrayList<>();
    ArrayList<Integer> cardNumbers = new ArrayList<>();

    public Card(ArrayList<Integer> winningNumbers, ArrayList<Integer> cardNumbers) {
        this.winningNumbers = winningNumbers;
        this.cardNumbers = cardNumbers;
    }

    public Card(String[] card) {
        /* Composed of:
         * [0] space separated winningNumbers
         * [1] space separated cardNumbers
         * */
        String[] win = card[0].split(" ");
        String[] num = card[1].split(" ");

        for (String str : win) {
            winningNumbers.add(Integer.parseInt(str));
        }
        for (String str : num) {
            cardNumbers.add(Integer.parseInt(str));
        }
    }

    @Override
    public String toString() {
        return "Day4.Card{" +
                "winningNumbers=" + winningNumbers +
                ", cardNumbers=" + cardNumbers +
                '}';
    }

    public ArrayList<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(ArrayList<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public ArrayList<Integer> getCardNumbers() {
        return cardNumbers;
    }

    public void setCardNumbers(ArrayList<Integer> cardNumbers) {
        this.cardNumbers = cardNumbers;
    }
}
