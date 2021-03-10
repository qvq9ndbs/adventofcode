package adventofcode.code;

import adventofcode.shared.reader.Reader;

import java.util.*;
import java.util.Map.*;

public class Day08 {
    private final static Reader reader = new Reader();
    private static final String path = "src/main/resources/input/day08.txt";
    private static final String ACC = "acc";
    private static final String JMP = "jmp";
    private static final String NOP = "nop";

    private int accumulator = 0;
    private int instructionCounter = 0;

    public static void main(String[] args) {
        Day08 logic = new Day08();
        System.out.println("\n------ DAY SIX ------\n");
        // logic.partOne();
        logic.partTwo();
    }

    private List<Entry<String, Integer>> setUp(){
        List<String> input = reader.readLines(path);
        List<Entry<String, Integer>> commands = new ArrayList<>();
        for(String instruction : input) {
            String command = instruction.substring(0, 3);
            int value = interpretValue(instruction.substring(4));
            commands.add(new AbstractMap.SimpleEntry<>(command, value));
        }
        return commands;
    }

    private void partOne(){
        System.out.println("---- PART ONE ----\n");
        List<Entry<String, Integer>> commands = setUp();
        run(commands);
        System.out.println("Accumulator: " + accumulator);
    }

    private int interpretValue(String input){
        int result = Integer.parseInt(input.substring(1));
        if(input.charAt(0) == '-') result *= -1;
        return result;
    }

    private void partTwo(){
        System.out.println("---- PART TWO ----\n");
        List<Entry<String, Integer>> commands = setUp();

        int counter = countJMP(commands);

        for(int i = 1; i <= counter; i++){
            accumulator = 0;
            instructionCounter = 0;
            runWithException(commands, replaceCommand(commands, JMP, i));


        }

        counter = countNOP(commands);

        for(int i = 1; i <= counter; i++){
            accumulator = 0;
            instructionCounter = 0;
            runWithException(commands, replaceCommand(commands, NOP, i));



        }

    }

    private void runWithException(List<Entry<String, Integer>> commands, int exception){
        boolean[] hasBeenVisited = new boolean[commands.size()];

        while(!hasBeenVisited[instructionCounter] && instructionCounter < commands.size()){
            hasBeenVisited[instructionCounter] = true;
            Entry<String, Integer> currentEntry = commands.get(instructionCounter);
            switch(currentEntry.getKey()){
                case ACC:
                    acc(currentEntry.getValue());
                    break;
                case JMP:
                    if(instructionCounter == exception){
                        nop();
                    }else{
                        jmp(currentEntry.getValue());
                    }
                    break;
                case NOP:
                    if(instructionCounter == exception){
                        jmp(currentEntry.getValue());
                    }else{
                        nop();
                    }
                    break;
            }
            if(instructionCounter == commands.size()){
                System.out.println("Accumulator: " + accumulator);
            }
        }
    }

    private void run(List<Entry<String, Integer>> commands){
        boolean[] hasBeenVisited = new boolean[commands.size()];

        while(!hasBeenVisited[instructionCounter]){
            hasBeenVisited[instructionCounter] = true;
            Entry<String, Integer> currentEntry = commands.get(instructionCounter);
            switch(currentEntry.getKey()){
                case ACC:
                    acc(currentEntry.getValue());
                    break;
                case JMP:
                    jmp(currentEntry.getValue());
                    break;
                case NOP:
                    nop();
                    break;
            }
        }
    }

    private int replaceCommand(List<Entry<String, Integer>> commands, String command, int number){
        int result = 0;
        for (int i = 0; i < commands.size(); i++) {
            Entry<String, Integer> entry = commands.get(i);
            if(entry.getKey().equals(command)){
                if(number == 0){
                    result = i;
                    break;
                }else{
                    number--;
                }
            }
        }

        return result;
    }

    private int countJMP(List<Entry<String, Integer>> commands){
        final int[] result = {0};
        commands.forEach((Entry<String, Integer> entry) -> {
            if(entry.getKey().equals("jmp")) result[0]++;
        });
        return result[0];
    }

    private int countNOP(List<Entry<String, Integer>> commands){
        final int[] result = {0};
        commands.forEach((Entry<String, Integer> entry) -> {
            if(entry.getKey().equals("nop")) result[0]++;
        });
        return result[0];
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
