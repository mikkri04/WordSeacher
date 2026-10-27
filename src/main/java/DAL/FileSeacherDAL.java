package DAL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileSeacherDAL {

    String filePath = "src/main/java/DAL/brit-a-z.txt";
    //File file = new File(filePath);
    public List<String> loadWords() {
        List<String> words = new ArrayList<>();
        try {
            words = Files.readAllLines(Path.of(filePath), StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }
}
