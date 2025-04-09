import java.util.Arrays;
import java.util.Scanner;

class LIS {
    public static void main(String []args){
      Scanner scanner = new Scanner(System.in);
      
      String input = scanner.nextLine();
      String arr[] = input.split(" ");
      int n = arr.length;
      int nums[] = new int[n];

      for (int i = 0; i < n; i++) {
        nums[i] = Integer.parseInt(arr[i]);
      }

      int []dp = new int[n];
      Arrays.fill(dp, 1); 

      int maxLength = 1;
      StringBuilder result=new StringBuilder();

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
          if (nums[j] < nums[i]) {  
            dp[i] = Math.max(dp[i], dp[j] + 1);
            if(maxLength<dp[i]){
              maxLength = Math.max(maxLength, dp[i]);
              
            }
          }
       
        }
       
      }

      System.out.println(maxLength);

      scanner.close();
    }
}
