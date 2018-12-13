
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class AnotherFileRead {

    public static void main(String[] args) {
        File files = new File("Resources\\another.txt");
        try {
            files.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // use class "Files" to read or write
        try {
            List<String> strings = Files.readAllLines(files.toPath());
            System.out.println(strings.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
