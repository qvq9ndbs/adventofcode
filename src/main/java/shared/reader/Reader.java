package shared.reader;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Reader {
    private Scanner scanner;

    public List<String> readStrings(String path){
        List<String> list = new ArrayList<>();
        try{
            scanner = new Scanner(new File(path));
            while(scanner.hasNext()){
                list.add(scanner.next());
            }
            scanner.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<List<String>> readBatches(String path){
        List<List<String>> lists = new ArrayList<>();
        List<String> rawInput = new ArrayList<>();
        List<String> saveInput = new ArrayList<>();
        try{
            scanner = new Scanner(new File(path));
            do {
                rawInput.add(scanner.nextLine());
            }while(scanner.hasNextLine());
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        rawInput.forEach((String s) -> {
            String[] strings = s.split(" ");
            for(String string : strings){
                    saveInput.add(string);
            }
        });


        saveInput.forEach(System.out::println);

        /*
        lists.add(DIVIDED SETS)
        */
        return lists;
    }
}
