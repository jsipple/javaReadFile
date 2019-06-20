import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.Map.Entry.*;

public class hmap {
    private HashMap<String, Integer> hmap = new HashMap<String, Integer>();
    public HashMap<String, Integer> getHmap() {
        return hmap;
    }

    public void addWord(String word) {
        if (hmap.containsKey(word)) {
            int occurances = hmap.get(word);
            occurances++;
            hmap.put(word, occurances);
        } else {
            hmap.put(word, 1);
        }
    }
    public void sort() {
//        need to use LinkedHashMap as it maintains insertion order
        Map<String, Integer> sorted = new LinkedHashMap<>();
                hmap
//                changes hashmap to a set
                .entrySet()
//              converting to stream so that I can use sorted
                .stream()
//              reversing here so that highest is first forEachOrdered just like .map() does it for each key) if want to change to a return need to use collect()
                .sorted(comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));

        System.out.println(sorted);

    }
}
