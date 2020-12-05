package shared.writer;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public static void write(String text){
        try{
            FileWriter writer = new FileWriter("src/main/resources/output/output.txt");
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
