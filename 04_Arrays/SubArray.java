public class SubArray {

    public static int numberOfSubarrays(int[] arr) {
        int n = arr.length;
        return (n * (n + 1)) / 2;
    }

    public static void printSubarrays(int[] arr) {
        int n = arr.length;
        for (int s = 0; s < n; s++) {
            for (int e = s; e < n; e++) {
                for (int i = s; i <= e; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void printSubarraysSum(int[] arr) {
        int n = arr.length;
        for (int s = 0; s < n; s++) {
            for (int e = s; e < n; e++) {
                int sum = 0;
                for (int i = s; i <= e; i++) {
                    sum += arr[i];
                }
                System.out.println("Sum of subarray [" + s + "," + e + "] = " + sum);
            }
        }
    }

    public static void printSubarraysSum2(int[] arr) {
        int n = arr.length;
        int[] pSum = new int[n];
        pSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pSum[i] = pSum[i - 1] + arr[i];
        }

        for (int s = 0; s < n; s++) {
            for (int e = s; e < n; e++) {
                if (s == 0) {
                    System.out.println("Sum of subarray [" + s + "," + e + "] = " + pSum[e]);
                } else {
                    System.out.println("Sum of subarray [" + s + "," + e + "] = " + (pSum[e] - pSum[s - 1]));
                }
            }
        }
    }

    public static long maxSubArraySum(int[] arr) {
        int sum = 0, ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            ans = Math.max(ans, sum);
            if (sum < 0) sum = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 4, -1, 2, 1, -5, 4};

        System.out.println("Number of subarrays: " + numberOfSubarrays(arr));
        System.out.println("\nSubarrays:");
        printSubarrays(arr);
        System.out.println("\nSubarray Sums:");
        printSubarraysSum(arr);
        System.out.println("\nSubarray Sums using Prefix Sum:");
        printSubarraysSum2(arr);
        System.out.println("\nMaximum Subarray Sum (Kadane's Algorithm): " + maxSubArraySum(arr));
    }
}
