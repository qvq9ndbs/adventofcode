package dayOne;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Logic {
    public static final String path = "src/main/java/dayOne/input";
    public static final int target = 2020;

    public static void main(String[] args) {
        Logic logic = new Logic();
        logic.partOne();
        logic.partTwo();
    }


    private List<Integer> setUp(){
        Scanner scanner;
        List<Integer> list = new ArrayList<>();
        try{
            scanner = new Scanner(new File(path));
            while(scanner.hasNext()){
                list.add(Integer.valueOf(scanner.next()));
            }
            scanner.close();
        }catch(Exception e){
            e.printStackTrace();
        }
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
