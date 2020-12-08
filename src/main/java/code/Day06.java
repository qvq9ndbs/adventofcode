package code;

import shared.reader.Reader;

import java.util.*;

public class Day06 {
    private final static Reader reader = new Reader();
    private static final String path = "src/main/resources/input/day06.txt";

    public static void main(String[] args) {
        Day06 logic = new Day06();
        System.out.println("\n------ DAY SIX ------\n");
        logic.partOne();
        logic.partTwo();
    }

    private String setUp(){
        return reader.readString(path);
    }

    private void partOne() {
        System.out.println("---- PART ONE ----\n");
        String[] groups = setUp().split("\\n\\n");
        System.out.println(groups.length);
        int count = 0;
        for (String group : groups) {
            group = group.replaceAll("[^a-z]", "");
            final HashSet<Character> set = new HashSet<>();
            for (char c : group.toCharArray()) {
                set.add(c);
            }
            count += set.size();
        }

        System.out.println("Count is: " + count);
    }


    private void partTwo() {
        System.out.println("---- PART TWO ----\n");
    }

}
