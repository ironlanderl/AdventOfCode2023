package Day6;

public class D6 {
    static int solveDay(Race[] races){
        int res = 1;
        for(Race race:races){
            res *= race.getPossibleWinNumber();
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
        int part1Res = solveDay(races);
        System.out.println("Part 1 : " + part1Res);
        races = new Race[]{new Race(59707878, 430121812131276L)};
        int part2Res = solveDay(races);
        System.out.println("Part 2 : " + part2Res);
    }
}
