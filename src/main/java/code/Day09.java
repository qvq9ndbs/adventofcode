package code;

import shared.reader.Reader;

import java.util.ArrayList;
import java.util.List;

public class Day09 {
    private final static Reader reader = new Reader();
    private final static String path = "src/main/resources/input/day09.txt";

    private final static long preambleSize = 25;

    public static void main(String[] args) {
        Day09 logic = new Day09();
        System.out.println("\n------ DAY NINE ------\n");
        logic.partOne();
        logic.partTwo();
    }

    private List<Long> setUp(){
        List<String> strings = reader.readLines(path);
        List<Long> longs = new ArrayList<>();
        strings.forEach(string -> {
            longs.add(Long.parseLong(string));
        });
        return longs;
    }

    // 102 : too low
    private void partOne(){
        System.out.println("---- PART ONE ----\n");
        List<Long> numbers = setUp();

        int result = 0;
        for(int i = 0; i < numbers.size(); i++){
            if(!testNumber(numbers.get(i))){
                result = i;
                break;
            }
        }
        System.out.println("The first wrong number is: " + numbers.get(result));
    }

    private boolean testNumber(long number){
        boolean result = false;
        for(int i = 0; i < preambleSize - 1; i++){
            long summand = preamble.get(i);
            for(int j = i + 1; j < preambleSize; j++){
                long checkValue = summand + preamble.get(j);
                if(checkValue == number){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    private void partTwo(){
        System.out.println("---- PART TWO ----\n");
    }

}
