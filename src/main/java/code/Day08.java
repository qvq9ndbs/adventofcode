package code;

import shared.reader.Reader;

import java.util.*;
import java.util.Map.*;

public class Day08 {
    private final static Reader reader = new Reader();
    private static final String path = "src/main/resources/input/day08.txt";

    private int accumulator = 0;
    private int instructionCounter = 0;

    public static void main(String[] args) {
        Day08 logic = new Day08();
        System.out.println("\n------ DAY SIX ------\n");
        logic.partOne();
        logic.partTwo();
    }

    private List<String> setUp(){
        return reader.readLines(path);
    }

    /**
     * 92: wrong
     */
    private void partOne(){
        System.out.println("---- PART ONE ----\n");
        List<String> input = setUp();
        List<Entry<String, Integer>> commands = new ArrayList<>();
        for(String instruction : input) {
            String command = instruction.substring(0, 3);
            int value = interpretValue(instruction.substring(4));
            commands.add(new AbstractMap.SimpleEntry<>(command, value));
        }

        boolean[] hasBeenVisited = new boolean[commands.size()];


        while(!hasBeenVisited[instructionCounter]){
            hasBeenVisited[instructionCounter] = true;
            Entry<String, Integer> currentEntry = commands.get(instructionCounter);
            System.out.println("Command: " + currentEntry.getKey() + currentEntry.getValue() + " - ACC: " + accumulator + " - IC: " + instructionCounter);
            switch(currentEntry.getKey()){
                case "acc":
                    acc(currentEntry.getValue());
                case "jmp":
                    jmp(currentEntry.getValue());
                case "nop":
                    nop();
            }
            instructionCounter--;
        }
        System.out.println("Accumulator: " + accumulator);
    }

    private int interpretValue(String input){
        int result = Integer.parseInt(input.substring(1));
        if(input.charAt(0) == '-') result *= -1;
        return result;
    }

    private void partTwo(){
        System.out.println("---- PART TWO ----\n");
        //List<String> input = setUp();
    }

    private void acc(int value){
        accumulator += value;
        nop();
    }

    private void jmp(int value){
        instructionCounter += value;
    }

    private void nop(){
        instructionCounter++;
    }
}
