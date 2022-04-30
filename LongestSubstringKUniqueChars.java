package slidingWindowProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKUniqueChars {

    public static void main(String ars[]) {
        String str = "aabacbebebe";
        int k = 3;
        int i = 0, j = 0, len = str.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < len) {
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
            if (map.size() < k) {
                j++;
            }
            else if (map.size() == k) {
                max = Integer.max(max, j - i + 1);
                j++;
            }
            else if (map.size() > k) {
                while (map.size() > k) {
                    map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) - 1);
                    if (map.get(str.charAt(i)) == 0)
                        map.remove(str.charAt(i));
                    i++;
                }
                j++;
            }
        }
        System.out.println("Logest Substrin size : "+ max);
    }
}
