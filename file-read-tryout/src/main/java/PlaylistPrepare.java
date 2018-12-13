import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vadym Mitin
 */
public class PlaylistPrepare {

    public static void main(String[] args) {
        Map<String, String> map = readMap();
        writeMap(map);
    }


    public static void writeMap(Map<String, String> map) {
//        String path = PlaylistPrepare.class.getClassLoader()
//                .getResource("prepared.txt").getPath();
        String path = "E:\\javaProjects\\java-tryouts\\file-read-tryout\\src\\main\\resources\\prepared.txt";

        File prepared = new File(String.valueOf(path));

        try {
            FileWriter fileWriter = new FileWriter(prepared);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (String s : map.keySet()) {
                System.out.println(s + ";" + map.get(s));
                writer.write(s + ";" + map.get(s));
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Return map (name, author)
     *
     * @return Map
     */
    public static Map<String, String> readMap() {


        // take resource from jar file (in the project they are in the "target" folder)
        InputStream playlist =
                PlaylistPrepare.class.getClassLoader()
                        .getResourceAsStream("playlist.txt");

        InputStreamReader reader = new InputStreamReader(playlist);
        BufferedReader br = new BufferedReader(reader);

        Map<String, String> map = new HashMap<>();

        try {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("¦");
//                System.out.println(split[1] + "; " + split[2]);
                map.put(split[1], split[2]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
