import java.util.Scanner;

public class LongestCommonSubString {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str1 = scanner.nextLine();
    String str2 = scanner.nextLine();
    
    int end_index = -1, max_length = 0;  
    int m = str1.length(), n = str2.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          if (dp[i][j] > max_length) {
            max_length = dp[i][j];
            end_index = i; 
          }
        }
      }
    }

    if (max_length == 0) {
      System.out.println("No common substring found.");
    } else {
      System.out.println(str1.substring(end_index - max_length, end_index)); 
    }

    scanner.close();
  }
}
