
import javax.sound.midi.Patch;
import java.io.File;
import java.io.IOException;

public class SomeFile {

    public static void main(String[] args) {

        // разделитель для текущей ОС (типа C:\\)
//        System.out.println(file.pathSeparator);
//        System.out.println(file.pathSeparatorChar);

//        Patch pp = new Patch()
// Создание обьекта файла и задание его названия + путь в папку ресурсі
        System.out.println("create new file Resources\\Something.txt");

        File file = new File("Resources\\Something.txt");
        try {
            // Создание файла на диске
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("File cant create");
//            e.printStackTrace();
        }

        System.out.println(file.getAbsolutePath());


        // temporary files
        System.out.println("Create temp file pref _to   suff _do");
        try {
            file = file.createTempFile("_to", "_do");
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("cant create temp file");
        }
        System.out.println(file.getAbsolutePath());


    }
}
