package slidingWindowProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MaxOfAllSubArrays {
    public static void main(String[] args) {
        int arr[] = {3, 1, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int i = 0, j = 0, len = arr.length;
        List<Integer> max = new ArrayList<>();
        ArrayDeque<Integer> list = new ArrayDeque<>();
        while (j < len) {
            while (!list.isEmpty() && list.peek() < arr[j]) {
                list.removeLast();
            }
            list.add(arr[j]);
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                max.add(list.getFirst());
                if (list.getFirst() == arr[i])
                    list.removeFirst();
                i++;
                j++;
            }
        }
        System.out.println(max);
    }
}
