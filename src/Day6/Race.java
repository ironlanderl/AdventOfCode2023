package Day6;

import java.math.BigInteger;
import java.util.ArrayList;

public class Race {
    private int time;
    private int distance;
    private BigInteger distaneBig;

    public Race(int time, int distance) {
        this.time = time;
        this.distance = distance;
    }
    public Race(int time, BigInteger distance) {
        this.time = time;
        this.distaneBig = distance;
    }

    public Integer[] getPossibleWinTimes(){
        ArrayList<Integer> winningTimes = new ArrayList<>();
        int speed;
        int distanceTravelled;
        /* Check all possible holding times from 0 to time */
        for(int i = 0; i <= time; i++){
            speed = i;
            /* Check for travel time and distance */
            distanceTravelled = speed * (time - i);
            /* If distance travelled > wr distance */
            if (distanceTravelled > distance){
                winningTimes.add(i);
            }
        }
        return winningTimes.toArray(new Integer[0]);
    }
    public Integer[] getPossibleWinTimesBig(){
        ArrayList<Integer> winningTimes = new ArrayList<>();
        int speed;
        BigInteger distanceTravelled;
        /* Check all possible holding times from 0 to time */
        for(int i = 0; i <= time; i++){
            speed = i;
            /* Check for travel time and distance */
            distanceTravelled = BigInteger.valueOf((long) speed * (time - i));
            /* If distance travelled > wr distance */
            if (distanceTravelled.compareTo(distaneBig) > 0){
                winningTimes.add(i);
            }
        }
        return winningTimes.toArray(new Integer[0]);
    }

    public int getPossibleWinNumber(){
        return getPossibleWinTimes().length;
    }
    public int getPossibleWinNumberBig(){
        return getPossibleWinTimesBig().length;
    }

    @Override
    public String toString() {
        return "Day6.Race{" +
                "time=" + time +
                ", distance=" + distance +
                '}';
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
