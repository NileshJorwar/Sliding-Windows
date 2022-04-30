package slidingWindowProblems;

public class MaxSumInSubString {
    public static void main(String[] args) {
        int k = 3;
        int arr[] = {2, 4, 5, 7, 1, 2, 6};
        int res = bruteForce(k, arr);
        System.out.println("Max Sum: " + res);
        int res1 = slidingWindowMaxSumSubarray(k, arr);
        System.out.println("Max Sum Using Sliding Windows: " + res1);
    }

    public static int slidingWindowMaxSumSubarray(int k, int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0, i = 0, j = 0, len = arr.length;
        while (j < len) {
            //Perform early calculations
            sum += arr[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                //Perform main computations
                maxSum = Math.max(maxSum, sum);
                //Remove from front to keep moving the window ahead
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }

    public static int bruteForce(int k, int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            if (maxSum < sum)
                maxSum = sum;
        }
        return maxSum;
    }
}
