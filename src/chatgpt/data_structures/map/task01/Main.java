package chatgpt.data_structures.map.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

    }

    public static Map<Integer,List<String>> groupByLength(List<String> words){
        Map<Integer,List<String>> res = new TreeMap<>();
        for (String w : words) {
            int key = w.length();
            res.computeIfAbsent(key, k -> new ArrayList<>());
            res.get(key).add(w);
        }
        return res;
    }



    public static Map<String,Integer> mergeDictionaries(Map<String,Integer> d1, Map<String,Integer> d2){
        Map<String, Integer> res = new TreeMap<>(d2);
        for (String key : d1.keySet()) {
            res.merge(key, d1.get(key), (k, v)-> {
                if (res.get(key) == null) {
                    return v;
                } else {
                    return v + res.get(key);
                }
            });
        }

        return res;
    }



    public static void incrementCount(Map<String, Integer> counts, String key) {
        counts.compute(key, (k, v) -> {
            if (v == null) {
                return 1;
            } else {
                return v + 1;
            }
        });
    }



}
