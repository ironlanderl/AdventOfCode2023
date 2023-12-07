package Day6;

import java.util.ArrayList;

public class Race {
    private long time;
    private long distance;

    public Race(long time, long distance) {
        this.time = time;
        this.distance = distance;
    }

    public Integer[] getPossibleWinTimes() {
        ArrayList<Integer> winningTimes = new ArrayList<>();
        int speed;
        long distanceTravelled;
        /* Check all possible holding times from 0 to time */
        for (int i = 0; i <= time; i++) {
            speed = i;
            /* Check for travel time and distance */
            distanceTravelled = speed * (time - i);
            /* If distance travelled > wr distance */
            if (distanceTravelled > distance) {
                winningTimes.add(i);
            }
        }
        return winningTimes.toArray(new Integer[0]);
    }

    public int getPossibleWinNumber() {
        return getPossibleWinTimes().length;
    }

    @Override
    public String toString() {
        return "Day6.Race{" +
                "time=" + time +
                ", distance=" + distance +
                '}';
    }
}
