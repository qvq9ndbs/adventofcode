package code;

import shared.reader.*;

import java.util.*;

public class Day04 {
    private static final Reader reader = new Reader();
    private static final String path = "src/main/resources/day04.txt";

    public static void main(String[] args) {
        Day04 logic = new Day04();
        System.out.println("\n------ DAY FOUR ------\n");
        logic.partOne();
        logic.partTwo();
    }

    private List<List<Map<String, String>>> setUp(){
        List<List<Map<String, String>>> list = reader.readBatches(path);
        return list;
    }

    private void partOne(){
        List<List<Map<String, String>>> list = setUp();
    }

    private void partTwo(){

    }

}
