package shared.reader;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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
    public List<String> readLines(String path){
        List<String> list = new ArrayList<>();
        try{
            scanner = new Scanner(new File(path));
            while(scanner.hasNextLine()){
                list.add(scanner.nextLine());
            }
            scanner.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public String readString(String path){
        String result = "";
        try{
            result = Files.readString(Path.of(path));
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
