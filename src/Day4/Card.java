package Day4;

import java.util.ArrayList;

public class Card {
    ArrayList<Integer> winningNumbers;
    ArrayList<Integer> cardNumbers;

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
