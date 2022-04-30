package slidingWindowProblems;

public class MinSumInSubArray {

    public static void main(String[] args) {
        int k = 3;
        int arr[] = {2, 4, 5, 7, 1, 2, 6};
        int res = bruteForce(k, arr);
        System.out.println("Min Sum: " + res);
        int res1 = slidingWindowMaxSumSubarray(k, arr);
        System.out.println("Min Sum Using Sliding Windows: " + res1);
    }

    public static int slidingWindowMaxSumSubarray(int k, int arr[]) {
        int minSum = Integer.MAX_VALUE;
        int sum = 0, i = 0, j = 0, len = arr.length;
        while (j < len) {
            sum = sum + arr[j];
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                minSum = Math.min(minSum, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        return minSum;
    }

    public static int bruteForce(int k, int arr[]) {
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum = sum + arr[j];
            }
            if (minSum > sum)
                minSum = sum;
        }
        return minSum;
    }
}
