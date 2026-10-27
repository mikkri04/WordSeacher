package DAL;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileWriterDAL {
    String filePath = "src/main/java/DAL/history";
    File file = new File("src/main/java/DAL/history");
    public void write(String input, boolean first){
        System.out.println(input);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            if (first == false) {bw.newLine();}
            bw.write(input);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String> loadWords() {
        List<String> words = new ArrayList<>();
        try {
            words = Files.readAllLines(Path.of(filePath), StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }

    public void clearHistory(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
