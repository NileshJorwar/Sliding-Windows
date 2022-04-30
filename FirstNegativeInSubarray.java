package slidingWindowProblems;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeInSubarray {
    public static void main(String[] args) {
        int k = 3;
        int arr[] = {12, -1, -7, 8, -16, 30, 16, 28};
        List<Integer> res = bruteForce(k, arr);
        System.out.println("Max Sum: " + res);
        List<Integer> res1 = slidingWindowMaxSumSubarray(k, arr);
        System.out.println("Max Sum Using Sliding Windows: " + res1);
    }

    public static List<Integer> bruteForce(int k, int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>(arr.length - k + 1);
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    list.add(arr[j]);
                    break;
                }
            }
        }
        return list;
    }

    public static List<Integer> slidingWindowMaxSumSubarray(int k, int arr[]) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0, len = arr.length;
        while (j < len) {
            if (arr[j] < 0) {
                list.add(arr[j]);
            }
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                if (!list.isEmpty()) {
                    res.add(list.get(0));
                    if (arr[i] == list.get(0))
                        list.remove(0);
                } else {
                    res.add(0);
                }
                i++;
                j++;
            }
        }
        System.out.println(res);
        return res;
    }
}
