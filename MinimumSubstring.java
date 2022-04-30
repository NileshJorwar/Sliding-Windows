package slidingWindowProblems;

import java.util.*;

public class MinimumSubstring {
    public static void main(String[] args) {
        String s = "tttmkatptat";
        String t = "ttaaa";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = map.size();
        int i = 0, j = 0, len = s.length();
        while (j < len) {
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) - 1);
                if (map.get(s.charAt(j)) == 0)
                    count--;
                j++;
            } else if (!map.containsKey(s.charAt(j))) {
                j++;
            }
            if (count == 0) {
                while (count == 0) {
                    if (map.containsKey(s.charAt(i))) {
                        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                        if (map.get(s.charAt(i)) > 0) {
                            count++;
                            System.out.println("Len: " + (j-i));
                        }

                    }
                    i++;
                }
            }

        }
    }
}
