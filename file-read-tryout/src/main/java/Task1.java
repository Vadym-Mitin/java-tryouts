
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task1 {
    public static void copyPaste(File a, File b) throws IOException {
//        FileInputStream input = new FileInputStream(a.getAbsoluteFile());
        byte[] bytes = Files.readAllBytes(Paths.get(a.getAbsolutePath()));
        System.out.println(a.getAbsolutePath());
        Files.write(Paths.get(b.getAbsolutePath()), bytes);
        System.out.println(b.getAbsolutePath());
//        String by = new String (bytes);
//        String s = by+"|||_______Something New____||||";
//        Files.write(Paths.get(b.getAbsolutePath()),s.getBytes());
    }

    public static void copyPasteStreams(File source, File destination) throws IOException {
        FileInputStream input = new FileInputStream(source);
        FileOutputStream out = new FileOutputStream(destination);
        byte[] bytes = new byte[input.available()];
//        byte[] bytes = new byte[(int) source.length()];

        input.read(bytes);
        out.write(bytes);
    }


    public static void main(String[] args) {
        File fileCopy = new File("Resources\\FileCopy.txt");
        File filePaste = new File("Resources\\FilePaste.txt");

        if (!filePaste.exists()) try {
            filePaste.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
//fileCopy.exists()
//        try {
//            copyPaste(fileCopy, filePaste);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            copyPasteStreams(fileCopy, filePaste);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
