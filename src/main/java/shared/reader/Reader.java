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

}
