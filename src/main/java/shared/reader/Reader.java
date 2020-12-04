package shared.reader;

import java.io.File;
import java.util.*;

public class Reader {
    private Scanner scanner;
    public static final String SPACE = " ";

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

    public List<List<Map<String, String>>> readBatches(String path){
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
            String[] strings = s.split(SPACE);
            saveInput.addAll(Arrays.asList(strings));
        });

        List<List<Map<String, String>>> mapList = new ArrayList<>();
        List<Map<String, String>> strings = new ArrayList<>();
        for(String string : saveInput){
            if(!string.isEmpty()){
                Map<String, String> map = new HashMap<>();
                int colon = string.indexOf(':');
                map.put(string.substring(0, colon), string.substring(colon));
                strings.add(map);
            }else{
                mapList.add(strings);
                strings = new ArrayList<>();
            }
        }
        System.out.println(mapList);
        return mapList;
    }
}
