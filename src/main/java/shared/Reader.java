package shared;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    public List<String> read(String path){
        Scanner scanner;
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
