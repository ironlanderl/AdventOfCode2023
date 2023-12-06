package Day6;

import java.math.BigInteger;

public class D6 {
    static int part1(Race[] races){
        int res = 1;
        for(Race race:races){
            res *= race.getPossibleWinNumber();
        }
        return res;
    }
    static int part2(Race[] races){
        int res = 1;
        for(Race race:races){
            res *= race.getPossibleWinNumberBig();
        }
        return res;
    }
    public static void main(String[] args) {
        Race[] races = {
                new Race(59, 430),
                new Race(70, 1218),
                new Race(78, 1213),
                new Race(78, 1276)
        };
        int part1Res = part1(races);
        System.out.println("Part 1 : " + part1Res);
        races = new Race[]{new Race(59707878, new BigInteger("430121812131276"))};
        int part2Res = part2(races);
        System.out.println("Part 2 : " + part2Res);
    }
}
