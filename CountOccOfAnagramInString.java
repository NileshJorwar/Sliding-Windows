package slidingWindowProblems;

import java.util.HashMap;
import java.util.Map;

public class CountOccOfAnagramInString {
    public static void main(String[] args) {
        String s = "aababaabbaaaba";
        String pattern = "aaba";
        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        int count = map.size();
        int res = 0;
        int k = pattern.length();
        int len = s.length();
        int i = 0, j = 0;
        while (j < len) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) - 1);
            if (map.get(s.charAt(j)) == 0)
                count--;
            if (j - i + 1 < k) j++;
            else if (j - i + 1 == k) {
                if (count == 0)
                    res++;
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                if (map.get(s.charAt(i)) == 1)
                    count++;
                i++;
                j++;
            }
        }
        System.out.println("res:" + res);
    }
}
