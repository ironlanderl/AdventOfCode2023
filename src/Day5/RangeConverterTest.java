package Day5;

import org.junit.jupiter.api.Test;

import Day5.RangeConverter;

import java.math.BigInteger;

import static Day5.D5.readFile;
import static org.junit.jupiter.api.Assertions.*;

class RangeConverterTest {
    @Test
    void testRangeConversions(){
        RangeConverter range1 = new RangeConverter(BigInteger.valueOf(50),
                BigInteger.valueOf(92),
                BigInteger.valueOf(2));

        RangeConverter range2 = new RangeConverter(BigInteger.valueOf(52),
                BigInteger.valueOf(50),
                BigInteger.valueOf(48));

        Converter converters = new Converter();
        converters.addConverter(range1);
        converters.addConverter(range2);


        assertEquals(BigInteger.valueOf(14), converters.convert(BigInteger.valueOf(14)));
        assertEquals(BigInteger.valueOf(81), converters.convert(BigInteger.valueOf(79)));
        assertEquals(BigInteger.valueOf(57), converters.convert(BigInteger.valueOf(55)));
        assertEquals(BigInteger.valueOf(13), converters.convert(BigInteger.valueOf(13)));
    }
    @Test
    void solvePart1(){
        String[] lines = readFile("src/Day5/demo.txt");
        BigInteger value = D5.solvePart1(lines);
        assertEquals(new BigInteger("35"), value);
    }
}