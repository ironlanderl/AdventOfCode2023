package Day6;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class Day6Tests {
    @Test
    void testTravelTimes(){
        assertEquals(4, new Race(7, 9).getPossibleWinNumber());
        assertEquals(8, new Race(15, 40).getPossibleWinNumber());
        assertEquals(9, new Race(30, 200).getPossibleWinNumber());

        assertEquals(71503, new Race(71530, 940200).getPossibleWinNumber());
    }
}