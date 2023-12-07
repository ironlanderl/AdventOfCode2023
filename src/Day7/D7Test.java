package Day7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class D7Test {

    @Test
    void testPart1() {
        long result = 0;
        Hand hand1 = new Hand(765);
        Hand hand2 = new Hand(684);
        Hand hand3 = new Hand(28);
        Hand hand4 = new Hand(220);
        Hand hand5 = new Hand(483);

        hand1.addCard(Card.THREE);
        hand1.addCard(Card.TWO);
        hand1.addCard(Card.T);
        hand1.addCard(Card.THREE);
        hand1.addCard(Card.K);
        hand2.addCard(Card.T);
        hand2.addCard(Card.FIVE);
        hand2.addCard(Card.FIVE);
        hand2.addCard(Card.J);
        hand2.addCard(Card.FIVE);
        hand3.addCard(Card.K);
        hand3.addCard(Card.K);
        hand3.addCard(Card.SIX);
        hand3.addCard(Card.SEVEN);
        hand3.addCard(Card.SEVEN);
        hand4.addCard(Card.K);
        hand4.addCard(Card.T);
        hand4.addCard(Card.J);
        hand4.addCard(Card.J);
        hand4.addCard(Card.T);
        hand5.addCard(Card.Q);
        hand5.addCard(Card.Q);
        hand5.addCard(Card.Q);
        hand5.addCard(Card.J);
        hand5.addCard(Card.A);

        ArrayList<Hand> hands = new ArrayList<>();
        hands.add(hand1);
        hands.add(hand2);
        hands.add(hand3);
        hands.add(hand4);
        hands.add(hand5);

        result = D7.solvePart1(hands);

        assertEquals(6440, result);
    }

    @Test
    void testCardsTypes() {
        Hand hand = new Hand(1);
        hand.addCard(Card.A);
        hand.addCard(Card.A);
        hand.addCard(Card.A);
        hand.addCard(Card.A);
        hand.addCard(Card.A);
        assertEquals(Hand.CardType.FIVE, hand.getType());

        hand = new Hand(1);
        hand.addCard(Card.A);
        hand.addCard(Card.A);
        hand.addCard(Card.EIGHT);
        hand.addCard(Card.A);
        hand.addCard(Card.A);
        assertEquals(Hand.CardType.FOUR, hand.getType());

        hand = new Hand(1);
        hand.addCard(Card.TWO);
        hand.addCard(Card.THREE);
        hand.addCard(Card.THREE);
        hand.addCard(Card.THREE);
        hand.addCard(Card.TWO);
        assertEquals(Hand.CardType.FULL, hand.getType());

        hand = new Hand(1);
        hand.addCard(Card.T);
        hand.addCard(Card.T);
        hand.addCard(Card.T);
        hand.addCard(Card.NINE);
        hand.addCard(Card.EIGHT);
        assertEquals(Hand.CardType.THREE, hand.getType());

        hand = new Hand(1);
        hand.addCard(Card.TWO);
        hand.addCard(Card.THREE);
        hand.addCard(Card.FOUR);
        hand.addCard(Card.THREE);
        hand.addCard(Card.TWO);
        assertEquals(Hand.CardType.TWO, hand.getType());

        hand = new Hand(1);
        hand.addCard(Card.A);
        hand.addCard(Card.TWO);
        hand.addCard(Card.THREE);
        hand.addCard(Card.A);
        hand.addCard(Card.FOUR);
        assertEquals(Hand.CardType.ONE, hand.getType());

        hand = new Hand(1);
        hand.addCard(Card.TWO);
        hand.addCard(Card.THREE);
        hand.addCard(Card.FOUR);
        hand.addCard(Card.FIVE);
        hand.addCard(Card.SIX);
        assertEquals(Hand.CardType.HIGH, hand.getType());
    }

}