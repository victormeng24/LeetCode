package SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int count = words.length;
        if (count == 0) return list;
        int len = words[0].length();
        for (String t : words) {
            if (!map.containsKey(t)) map.put(t, 1);
            else map.put(t, map.get(t) + 1);
        }
        Map<String, Integer> countmap;
        for (int i = 0; i + count * len <= s.length(); i++) {
            countmap = new HashMap<String, Integer>(map);
            for (int j = i; j + len <= s.length(); j += len) {
                String str = s.substring(j, j + len);
                if (!countmap.containsKey(str)) break;
                if (countmap.containsKey(str)) {
                    int cot = countmap.get(str);
                    if (cot == 1) countmap.remove(str);
                    else countmap.put(str, cot - 1);
                    if (countmap.isEmpty()) {
                        list.add(i);
                        break;
                    }
                } else break;
            }

        }
        return list;
    }
}
