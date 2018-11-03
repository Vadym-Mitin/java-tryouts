import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Vadym Mitin
 */
public class HashMapTryout {
    public static void main(String[] args) {
        HashMap<String, String> hashmap = new HashMap<String, String>();

        hashmap.put("Васька", "11");
        hashmap.put("Мурзик", "22");
        hashmap.put("Рыжик", "33");
        hashmap.put("Барсик", "44");

        System.out.println("====for loop for entry set====");
        for (Map.Entry<String, String> entry : hashmap.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue());

        System.out.println("====set of keys====");
        for (String key : hashmap.keySet())
            System.out.println(key);

        System.out.println("====collection of values====");
        Collection<String> values = hashmap.values();
        for (String value : values) {
            System.out.println(value);
        }

        System.out.println("====iterator entry set====");
        Iterator<Map.Entry<String, String>> itr = hashmap.entrySet().iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

        System.out.println("====lambdas foreach====");
        hashmap.forEach((k, v) -> System.out.println(k + "; " + v));
    }
}
