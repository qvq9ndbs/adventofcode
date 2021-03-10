package adventofcode.code;

import adventofcode.shared.reader.Reader;

import java.util.*;

public class Day05 {
    private final static Reader reader = new Reader();
    private static final String path = "src/main/resources/input/day05.txt";

    public static void main(String[] args) {
        Day05 logic = new Day05();
        System.out.println("\n------ DAY FIVE ------\n");
        logic.partOne();
        logic.partTwo();
    }

    private List<String> setUp(){
        List<String> seats = reader.readStrings(path);
        System.out.println("Seats: " + seats.size());
        return seats;
    }

    private void partOne(){
        System.out.println("---- PART ONE ----\n");
        List<String> set = setUp();
        int highestId = 0;
        for(String s : set){
            int row = findRow(s.toCharArray());
            int seat = findSeat(s.toCharArray());
            int id = row * 8 + seat;
            if(id > highestId) {
                highestId = id;
            }
        }
        System.out.println("The highest seat ID is : " + highestId + "\n");
    }

    private void partTwo(){
        System.out.println("---- PART TWO ----\n");
        List<String> set = setUp();
        List<Integer> ids = new ArrayList<>();
        for(String s : set){
            ids.add(findRow(s.toCharArray()) * 8 + findSeat(s.toCharArray()));
        }
        Collections.sort(ids);
        int expectedId = ids.get(0);
        int result = 0;
        for(int id : ids){
            if(id != expectedId){
                result = expectedId;
                break;
            }else{
                expectedId = id + 1;
            }
        }
        System.out.println("My seat is: " + result);
    }

    private int findRow(char[] finder){
        int minRow = 0;
        int maxRow = 127;
        for(int i = 0; i < 7; i++){
            switch(finder[i]){
                case 'F':
                    maxRow = maxRow - (maxRow - minRow) / 2 - 1;
                    break;
                case 'B':
                    minRow = minRow + (maxRow - minRow) / 2 + 1;
                    break;
            }
        }
        return minRow;
    }

    private int findSeat(char[] finder){
        int minCol = 0;
        int maxCol = 7;
        for(int i = 7; i < 10; i++){
            switch(finder[i]){
                case 'L':
                    maxCol = maxCol - (maxCol - minCol) / 2 - 1;
                    break;
                case 'R':
                    minCol = minCol + (maxCol - minCol) / 2 + 1;
                    break;
            }
        }
        return minCol;
    }
}
