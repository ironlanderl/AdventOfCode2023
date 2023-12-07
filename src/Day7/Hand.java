package Day7;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Hand implements Comparable {
    private Card[] cards = new Card[5];
    private int cardKeeper = 0;
    private int bid = -1;

    public Hand(int bid) {
        this.bid = bid;
    }

    public void addCard(Card card) {
        cards[cardKeeper] = card;
        cardKeeper++;
    }

    public int getBid() {
        return bid;
    }

    @Override
    public String toString() {
        return "Day7.Hand{" +
                "cards=" + Arrays.toString(cards) +
                ", cardKeeper=" + cardKeeper +
                ", bid=" + bid +
                ", type=" + getType() +
                "}\n";
    }

    public CardType getType() {
        HashMap<Card, Integer> cardsPresent = new HashMap<>();

        for (Card card : cards) {
            cardsPresent.merge(card, 1, Integer::sum);
        }


        Integer[] singlePresence = cardsPresent.values().toArray(new Integer[1]);
        Arrays.sort(singlePresence, Collections.reverseOrder());
        System.out.println(Arrays.toString(singlePresence));

        switch (cardsPresent.size()) {
            /* Tutte diverse */
            case 5 -> {
                return CardType.HIGH;
            }
            /* Due uguali, resto diverso */
            case 4 -> {
                return CardType.ONE;
            }
            /* Due paia con uno diverso */
            case 3 -> {
                if (singlePresence[0].equals(singlePresence[1])) {
                    return CardType.TWO;
                } else {
                    return CardType.THREE;
                }

            }
            case 2 -> {
                if (Math.abs(singlePresence[0] - singlePresence[1]) == 3) {
                    return CardType.FOUR;
                } else {
                    return CardType.FULL;
                }
            }
            case 1 -> {
                return CardType.FIVE;
            }
        }

        return null;
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass() == this.getClass()) {
            Hand other = (Hand) o;
            Card[] thisCards = this.cards;
            Card[] otherCards = other.cards;

            CardType thisHandType = getType();
            CardType otherHandType = other.getType();

            if (!thisHandType.equals(otherHandType)) {
                return thisHandType.compareTo(otherHandType);
            }

            for (int i = 0; i < thisCards.length; i++) {
                if (thisCards[i] != otherCards[i]) {
                    return thisCards[i].compareTo(otherCards[i]);
                }
            }
        }
        return 0;
    }

    enum CardType {
        FIVE,
        FOUR,
        FULL,
        THREE,
        TWO,
        ONE,
        HIGH
    }
}
