package Day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Part2 {

    public static HashMap<Color, Integer> emptyColorIntegerMap() {
        return new HashMap<>(Map.of(Color.RED, 0, Color.GREEN, 0, Color.BLUE, 0));
    }

    public static String[] cleanStringArray(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].strip();
            strs[i] = strs[i].toUpperCase();
        }
        return strs;
    }

    public static void main(String[] args) {
        int powerSum = 0;
        try {
            Scanner scan = new Scanner(new FileInputStream("./src/Day2/input.txt"));
            while (scan.hasNextLine()) {
                /* Loop through games */
                String game = scan.nextLine();
                String[] rounds = cleanStringArray(game.split(":")[1].split(";"));
                HashMap<Color, Integer> roundMap = emptyColorIntegerMap();
                for (String round : rounds) {
                    /* Loop through single game, multiple rounds */
                    String[] ball_complete = cleanStringArray(round.split(","));
                    HashMap<Color, Integer> currentBallGroupMap = emptyColorIntegerMap();
                    for (String ball : ball_complete) {
                        /* Loop through single round, multiple balls */
                        Color ball_color = Color.valueOf(ball.split(" ")[1]);
                        int ball_value = Integer.parseInt(ball.split(" ")[0]);
                        currentBallGroupMap.put(ball_color, ball_value);

                    }
                    /* Current round ended, compare */
                    if(roundMap.get(Color.RED) < currentBallGroupMap.get(Color.RED)){
                        roundMap.put(Color.RED, currentBallGroupMap.get(Color.RED));
                    }
                    if(roundMap.get(Color.GREEN) < currentBallGroupMap.get(Color.GREEN)){
                        roundMap.put(Color.GREEN, currentBallGroupMap.get(Color.GREEN));
                    }
                    if(roundMap.get(Color.BLUE) < currentBallGroupMap.get(Color.BLUE)){
                        roundMap.put(Color.BLUE, currentBallGroupMap.get(Color.BLUE));
                    }
                }
                /* Current game ended, checking power */
                int power = roundMap.get(Color.RED) * roundMap.get(Color.BLUE) * roundMap.get(Color.GREEN);
                powerSum += power;
            }
            System.out.println(powerSum);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

