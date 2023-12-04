package Day4;

import java.util.ArrayList;

public class Card {
    ArrayList<Integer> winningNumbers = new ArrayList<>();
    ArrayList<Integer> cardNumbers = new ArrayList<>();

    @Override
    public String toString() {
        return "Day4.Card{" +
                "winningNumbers=" + winningNumbers +
                ", cardNumbers=" + cardNumbers +
                ", molteplicita=" + molteplicita +
                ", presences=" + getPresences() +
                ", points=" + getPoints() +
                "}\n";
    }

    int molteplicita = 1;

    public Card(ArrayList<Integer> winningNumbers, ArrayList<Integer> cardNumbers) {
        this.winningNumbers = winningNumbers;
        this.cardNumbers = cardNumbers;
    }

    public Card(String card) {
        /* Composed of:
         * [0] space separated winningNumbers
         * [1] space separated cardNumbers
         * */
        String[] cardSplit = card.split("\\|");
        String[] win = cardSplit[0].split(" ");
        String[] num = cardSplit[1].split(" ");

        for (String str : win) {
            if (!str.isEmpty())
                winningNumbers.add(Integer.parseInt(str));
        }
        for (String str : num) {
            if (!str.isEmpty())
                cardNumbers.add(Integer.parseInt(str));
        }
    }

    public int getPresences(){
        int presences = 0;
        for(int wantedNumber: winningNumbers){
            if (cardNumbers.contains(wantedNumber)){
                presences++;
            }
        }
        return presences;
    }

    public int getPoints(){
        /* Calculate points */
        return (int) Math.pow(2, getPresences() - 1);
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
