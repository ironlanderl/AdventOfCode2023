package Day3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class GridTests {

    @Test
    void neighborsContainsTests(){
        Grid2D<Integer> testing = new Grid2D<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);a.add(3);a.add(5);
        testing.addLine(a);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(2);b.add(4);b.add(6);
        testing.addLine(b);

        assertEquals(false, testing.neighborsContains(0,1,87));
        assertEquals(true, testing.neighborsContains(0,1,4));
        assertEquals(true, testing.neighborsContains(0,1,null));
        assertEquals(false, testing.neighborsContains(0,1,"hello"));
    }


    public static void main(String[] args) {
        Grid2D<Integer> testing = new Grid2D<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);a.add(3);a.add(5);
        System.out.println(testing);
        testing.addLine(a);
        System.out.println(testing);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(2);b.add(4);b.add(6);
        testing.addLine(b);
        System.out.println(testing);

        System.out.println(testing.getNeighbors(0,1));
        System.out.println(testing.neighborsContains(0,1,87));
        System.out.println(testing.neighborsContains(0,1,4));
        System.out.println(testing.neighborsContains(0,1,null));
        System.out.println(testing.neighborsContains(0,1,"hello!"));
    }
}
