
import java.io.*;
import java.util.Random;

public class SomeStreams {
//   static m fileStream;

    public static void main(String[] args) {

        // Первый способ читать файл
// try with resources if method is closeable (implement closeable )
        try (FileInputStream fileStream = new FileInputStream("Resources\\Something.txt")) {
            byte[] bytes = new byte[1024];
            while (fileStream.read(bytes) > 0) {
                System.out.println(new String(bytes));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ///________________________________________________________________________
        Random random = new Random();
        try (FileOutputStream outputStream = new FileOutputStream("Resources\\Something.txt")) {
            for (int i = 0; i < 100; i++) {
                String s = Long.toHexString(random.nextLong());
                String delimeter = "Й-Й";
                try {
                    outputStream.write(s.getBytes());
                    outputStream.write(delimeter.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
