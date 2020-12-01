package dayOne;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logic {
    public static final String path = "src/main/java/dayOne/input";
    public static final int target = 2020;

    public static void main(String[] args) {
        int target = 2020;
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
        List<Integer> list = setUp();

        //list.forEach(System.out::println);

        int target = 2020;
        int numberOne;
        int jPlaceholder = 0;
        int iPlaceholder = 0;
        for(int i = 0; i < list.size(); i++){
            numberOne = list.get(i);
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(j) == target - numberOne){
                    jPlaceholder = list.get(j);
                    break;
                }
            }
            if(jPlaceholder != 0){
                iPlaceholder = list.get(i);
                break;
            }
        }
        System.out.println(jPlaceholder + " - " + iPlaceholder);
        int result = jPlaceholder * iPlaceholder;
        System.out.println(result);
    }
}
