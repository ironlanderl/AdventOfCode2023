package Day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {

    @Test
    void solvePart2(){
        assertEquals(30, Part1.solvePart2("src/Day4/demo2.txt"));
    }

    @Test
    void solvePart1() {
        assertEquals(13, Part1.solvePart1("src/Day4/demo.txt"));
    }
}