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
        String groupString = setUp();
        String[] groups = groupString.split("\r\n\r\n");
        int count = 0;
        for(String group : groups){
            group = group.replaceAll("[^a-z]", "");
            count += countUniqueCharacter(group);
        }

        System.out.println("Count is: " + count);
    }

    private int countUniqueCharacter(String input){
        return (int) input.chars().distinct().count();
    }

    private void partTwo() {
        System.out.println("---- PART TWO ----\n");
        String groupString = setUp();
        String[] groups = groupString.split("\r\n\r\n");
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int count = 0;
        for(String group : groups){
            group = group.replaceAll("[^a-z]", "X");
            group = group.replaceAll("XX", "X");
            int participants = 1;
            for(char c : group.toCharArray()){
                if(c == 'X') participants++;
            }
            group = group.replaceAll("X", "");

            for(char c : alphabet){
                if(countAllCharacters(group, c, participants)) count++;
            }
        }
        System.out.println("Count is: " + count);
    }

    private boolean countAllCharacters(String input, char test, int target) {
        int count = 0;

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == test) count++;
        }

        return count == target;
    }
}
