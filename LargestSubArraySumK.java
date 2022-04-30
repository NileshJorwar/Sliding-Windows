package slidingWindowProblems;

public class LargestSubArraySumK {
    public static void main(String[] args) {
        int k = 5;
        int arr[] = { 4, 1, 1, -2, 1, 5};
        int sum = 0;
        int i = 0, j = 0, len = arr.length;
        int res = 0;

        while (j < len) {
            sum = sum + arr[j];
            if (sum < k) {
                j++;
            }
            if (sum == k) {
                res = Integer.max(res, j - i + 1);
                j++;
            }
            if (sum > k) {
                while (sum > k) {
//                    if()
                    sum = sum - arr[i];
                    i++;
                }
                j++;
            }
        }
        System.out.println("Largest Subarray : K : " + res);
    }
}


// define tasks with 10 tests
// detailed tasks
// scripts
// affinity digram based on CI and HE of existing
// sketches and low fidility diagram for new design
// run HR on new design
// might have to design fidility for both CI

