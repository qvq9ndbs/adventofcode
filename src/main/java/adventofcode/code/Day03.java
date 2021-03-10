package adventofcode.code;

import adventofcode.shared.reader.*;

import java.util.List;

public class Day03 {
    private static final Reader reader = new Reader();
    private static final String path = "src/main/resources/input/day03.txt";

    public static void main(String[] args) {
        Day03 logic = new Day03();
        System.out.println("\n------ DAY THREE ------\n");
        logic.partOne();
        logic.partTwo();
    }

    private String[] setUp(){
        final int[] counter = {0};
        List<String> list = reader.readStrings(path);
        list.forEach((String s) -> counter[0]++);
        String[] outputs = new String[counter[0]];
        counter[0] = 0;
        list.forEach((String s) -> {
            String output = "";
            for(int i = 0; i < s.length(); i++){
                output += s.charAt(i);
            }
            outputs[counter[0]] = output;
            counter[0]++;
        });

        return outputs;
    }

    private long toboggan(String[] input, int xSteps, int ySteps){
        StringBuilder map = new StringBuilder();
        int xCo = 0;
        int maxRowSize = input[0].length();
        for(int i = ySteps; i < input.length; i += ySteps){
            xCo = (xCo + xSteps) % maxRowSize;
            map.append(input[i].charAt(xCo));
        }
        return map.toString().chars().filter(ch -> ch == '#').count();
    }

    private void partOne(){
        System.out.println("---- PART ONE ----\n");
        String[] list = setUp();
        System.out.println("Encountered " + toboggan(list, 3, 1) + " trees.");
    }

    private void partTwo(){
        System.out.println("---- PART TWO ----\n");
        String[] list = setUp();
        long solution = toboggan(list, 1, 1);
        solution = solution * toboggan(list, 3, 1);
        solution = solution * toboggan(list, 5, 1);
        solution = solution * toboggan(list, 7, 1);
        solution = solution * toboggan(list, 1, 2);
        System.out.println("Multiplied to " + solution);
    }
}
