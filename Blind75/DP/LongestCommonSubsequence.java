package Blind75.DP;

class LongestCommonSubsequence {
  public static String longestCommonSubsequence(String text1, String text2) {
    int n = text1.length();
    int m = text2.length();

    int[][] dp = new int[n + 1][m + 1];
    
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    StringBuilder lcs = new StringBuilder();
    int i = n, j = m;
    while (i > 0 && j > 0) {
      if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
        lcs.append(text1.charAt(i - 1));
        i--;
        j--;
      } else if (dp[i - 1][j] > dp[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }

    return lcs.reverse().toString();
  }

  public static void main(String[] args) {
    String text1 = "abcde";
    String text2 = "ace";

    String lcs = longestCommonSubsequence(text1, text2);
    System.out.println("Longest Common Subsequence: " + lcs);
    System.out.println("Length: " + lcs.length());
  }
}
