package chatgpt.collections.maps.task01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

public class MapUtils {

    /**
     * 1. Подсчитать частоту слов в тексте:
     * принимает строку и возвращает Map<String,Integer>, где ключ —
     * слово (разделитель — пробел или пунктуация), а значение — число вхождений.
     *
     * @param text любой текст (не null)
     * @return частотный словарь
     * @throws IllegalArgumentException, если text == null
     */
    public static Map<String, Integer> wordFrequency(String text) {
        String[] words = text.split("[,\\s;!]+");
        Map<String, Integer> res = new TreeMap<>();
        for (String word : words) {
            if (res.containsKey(word)) {
                Integer oldCount = res.get(word);
                res.put(word, oldCount + 1);
            } else {
                res.put(word, 1);
            }
        }
        return res;
    }


    /**
     * 2. Инвертировать Map<K,V> в Map<V, List<K>>:
     * для каждого уникального значения v в оригинальном словаре
     * собрать список всех ключей k, которые вели к этому значению.
     * {"a":1, "b":1, "c":2, "d":3, "e":4, "f":2} ---> {1:["a", "b"], 2:["c", "f"], 3:["d"], 4:["e"]}
     *
     * @param map исходная Map<K,V> (не null)
     * @return инверсная мультимапа V → List<K>
     * @throws IllegalArgumentException, если map == null
     */
    public static <K, V> Map<V, List<K>> invert(Map<K, V> map) {
        Map<V, List<K>> res = new HashMap<>();
        for (V value : new HashSet<>(map.values())) {
            List<K> keys = new ArrayList<>();
            for (K key : map.keySet()) {
                if (map.get(key).equals(value)) {
                    keys.add(key);
                }
            }
            res.put(value, keys);
        }
        return res;


    }


    /**
     * 3. Объединение двух карт с суммой значений одинаковых ключей:
     * возвращает новый Map<K,Integer>, где для каждого ключа k
     * значение = sum of values from map1 and map2 (treat missing as 0).
     *
     * @param m1 первая Map<K,Integer> (не null)
     * @param m2 вторая Map<K,Integer> (не null)
     * @return новый Map с объединёнными суммами
     * @throws IllegalArgumentException, если m1 или m2 == null
     */
    public static <K> Map<K, Integer> mergeSum(Map<K, Integer> m1, Map<K, Integer> m2) {
        Set<K> keys = new HashSet<>();
        keys.addAll(m1.keySet());
        keys.addAll(m2.keySet());
        Map<K, Integer> res = new HashMap<>();
        for (K key : keys) {
            Integer val1 = m1.getOrDefault(key, 0);
            Integer val2 = m2.getOrDefault(key, 0);
            res.put(key, val1 + val2);
            /*if (m1.containsKey(key) && m2.containsKey(key)) {
                res.put(key, m1.get(key) + m2.get(key));
            } else if (m1.containsKey(key)) {
                res.put(key, m1.get(key));
            } else {
                res.put(key, m2.get(key));
            }*/
        }
        return res;
    }


    /**
     * 4. Получить значение по ключу с выбросом:
     * если ключ отсутствует, бросить NoSuchElementException с сообщением.
     *
     * @param map Map<K,V> (не null)
     * @param key ключ для поиска
     * @return V value
     * @throws IllegalArgumentException, если map == null
     * @throws NoSuchElementException,   если ключа нет в map
     */
    public static <K, V> V getOrThrow(Map<K, V> map, K key) {
        if(!map.containsKey(key)){
            throw new NoSuchElementException();
        }
        return map.get(key);

    }

}
