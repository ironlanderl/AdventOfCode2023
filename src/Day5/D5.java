package Day5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class D5 {
    public static String[] readFile(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new FileInputStream(filename));
            while (scan.hasNextLine()) {
                lines.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String[] tmp = new String[lines.size()];
        return lines.toArray(tmp);
    }

    public static BigInteger solvePart1(String[] lines){
        int i = 2;
        ArrayList<BigInteger> seeds = new ArrayList<>();
        Converter seedToSoil = new Converter();
        Converter soilToFertilizer = new Converter();
        Converter fertilizerToWater = new Converter();
        Converter waterToLight = new Converter();
        Converter lightToTemperature = new Converter();
        Converter temperatureToHumidity = new Converter();
        Converter humidityToLocation = new Converter();
        /* Split by \n\n */
        /* Currently at seeds. */
        String seedsString = lines[0];
        /* Remove seeds: */
        seedsString = seedsString.replace("seeds: ", "");
        /* Parse to bigint arraylist */
        for (String seedString: seedsString.split(" +")){
            seeds.add(new BigInteger(seedString));
        }

        System.out.println(seeds);

        i = extractData(lines, i, seedToSoil);
        System.out.println(seedToSoil);

        i = extractData(lines, i, soilToFertilizer);
        System.out.println(soilToFertilizer);

        i = extractData(lines, i, fertilizerToWater);
        System.out.println(fertilizerToWater);

        i = extractData(lines, i, waterToLight);
        System.out.println(waterToLight);

        i = extractData(lines, i, lightToTemperature);
        System.out.println(lightToTemperature);

        i = extractData(lines, i, temperatureToHumidity);
        System.out.println(temperatureToHumidity);

        i = extractData(lines, i, humidityToLocation);
        System.out.println(humidityToLocation);

        /* Now we calculate */
        runCalcs(seedToSoil, seeds);
        runCalcs(soilToFertilizer, seeds);
        runCalcs(fertilizerToWater, seeds);
        runCalcs(waterToLight, seeds);
        runCalcs(lightToTemperature, seeds);
        runCalcs(temperatureToHumidity, seeds);
        runCalcs(humidityToLocation, seeds);

        System.out.println(seeds);

        return seeds.stream().min(BigInteger::compareTo).get();
    }

    public static void runCalcs(Converter converter, ArrayList<BigInteger> source){
        source.replaceAll(converter::convert);
    }

    public static int extractData(String[] lines, int i, Converter genericConverter) {
        for(; i < lines.length && !lines[i].isEmpty(); i++){
            if (lines[i].matches("\\D+")){
                continue;
            }
            /* Values split by space */
            genericConverter.addConverter(new RangeConverter(
                    new BigInteger(lines[i].split(" ")[0]),
                    new BigInteger(lines[i].split(" ")[1]),
                    new BigInteger(lines[i].split(" ")[2])
            ));
        }
        return i + 1;
    }

    public static void main(String[] args) {
        String[] lines = readFile("src/Day5/demo.txt");
        solvePart1(lines);
    }
}
