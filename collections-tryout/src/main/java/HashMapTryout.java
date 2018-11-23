import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Vadym Mitin
 */
public class HashMapTryout {
    static HashMap<String, String> hashmap = new HashMap<String, String>();

    public static void main(String[] args) {
        hashmap.put("Васька", "11");
        hashmap.put("Мурзик", "22");
        hashmap.put("Рыжик", "33");

        hashmap.put("Барсик", "44");
        hashmap.put("Барсик", "54");
        hashmap.put("Барсик", "999");
//        HashMapTryout.
        doit(hashmap);

    }

    static <K, V> void doit(HashMap<K, V> hashmap) {
        System.out.println("====for loop for entry set====");
        for (Map.Entry<K, V> entry : hashmap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("====set of keys====");
        for (K key : hashmap.keySet())
            System.out.println(key);

        System.out.println("====collection of values====");
        Collection<V> values = hashmap.values();
        for (V value : values) {
            System.out.println(value);
        }

        System.out.println("====iterator entry set====");
        Iterator<Map.Entry<K, V>> itr = hashmap.entrySet().iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

//        System.out.println("====lambdas foreach====");
//        hashmap.forEach((k, v) -> System.out.println(k + "; " + v));
    }

}
