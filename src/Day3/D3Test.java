package Day3;

import static Day3.D3.readFile;
import static org.junit.jupiter.api.Assertions.*;

class D3Test {

    @org.junit.jupiter.api.Test
    void runDay() {
        String[] lines = readFile("./src/Day3/demo.txt");
        assertEquals(413, D3.runPart1(lines));
    }
}