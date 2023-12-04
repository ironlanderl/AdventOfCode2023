package Day3;

import static Day3.Part1.readFile;
import static org.junit.jupiter.api.Assertions.*;

class Part1Test {

    @org.junit.jupiter.api.Test
    void runDay() {
        String[] lines = readFile("./src/Day3/demo.txt");
        assertEquals(413, Part1.runDay(lines));
    }
}