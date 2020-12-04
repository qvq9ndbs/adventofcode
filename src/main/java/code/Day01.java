package code;

import shared.reader.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 {
    public static final String path = "src/main/resources/day01.txt";
    public static final int target = 2020;
    public static final Reader reader = new Reader();

    public static void main(String[] args) {
        Day01 logic = new Day01();
        System.out.println("------ DAY ONE ------\n");
        logic.partOne();
        logic.partTwo();
    }

    private List<Integer> setUp(){
        List<Integer> list  = new ArrayList<>();
        reader.readStrings(path).forEach((String s) -> list.add(Integer.valueOf(s)));
        return list;
    }

    private void partOne(){
        System.out.println("---- PART ONE ----\n");
        List<Integer> list = setUp();

        int numberOne;

        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            numberOne = list.get(i);
            int idx = Collections.binarySearch(list, target - numberOne);
            if(idx >= 0){
                System.out.println(numberOne + " - " + list.get(idx));
                System.out.println(numberOne * list.get(idx));
                return;
            }
        }
    }

    private void partTwo(){
        System.out.println("\n---- PART TWO ----\n");
        List<Integer> list = setUp();

        int numberOne;
        int numberTwo;

        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            numberOne = list.get(i);
            for(int j = i + 1; j < list.size(); j++){
                numberTwo = list.get(j);
                int idx = Collections.binarySearch(list, target - numberOne - numberTwo);
                if(idx >= 0){
                    System.out.println(numberOne + " - " + numberTwo + " - " + list.get(idx));
                    System.out.println(numberOne * numberTwo * list.get(idx));
                    return;
                }
            }
        }
    }
}
