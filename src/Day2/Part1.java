package Day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Part1 {
    public static HashMap<Color, Integer> toFind = new HashMap<>(Map.of(Color.RED, 12, Color.GREEN, 13, Color.BLUE, 14));

    public static Map<Color, Integer> emptyColorIntegerMap() {
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
        int idSum = 0;
        Boolean round_void = false;
        int currentId = 1;
        try {
            Scanner scan = new Scanner(new FileInputStream("./src/Day2/input.txt"));
            while (scan.hasNextLine()) {
                /* Loop through games */
                String game = scan.nextLine();
                String[] rounds = cleanStringArray(game.split(":")[1].split(";"));
                for (String round : rounds) {
                    /* Loop through single game, multiple rounds */
                    String[] ball_complete = cleanStringArray(round.split(","));
                    Map<Color, Integer> currentMap = emptyColorIntegerMap();
                    for (String ball : ball_complete) {
                        /* Loop through single round, multiple balls */
                        Color ball_color = Color.valueOf(ball.split(" ")[1]);
                        int ball_value = Integer.parseInt(ball.split(" ")[0]);
                        currentMap.put(ball_color, currentMap.get(ball_color) + ball_value);
                    }
                    if (
                            currentMap.get(Color.RED) > toFind.get(Color.RED) ||
                                    currentMap.get(Color.GREEN) > toFind.get(Color.GREEN) ||
                                    currentMap.get(Color.BLUE) > toFind.get(Color.BLUE)
                    ){
                        /* Current balls are more */
                        /* Skip to next round */
                        round_void = true;
                    }
                }
                if (!round_void){
                    idSum += currentId;
                }
                round_void = false;
                currentId++;
                System.out.println(currentId);


            }
            System.out.println(idSum);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

