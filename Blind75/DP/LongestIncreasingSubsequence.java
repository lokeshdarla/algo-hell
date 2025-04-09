package Blind75.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
  static int longestIncreasingSubsequence(int nums[]) {
    int n = nums.length;
    int []dp=new int[n];
    int []prev=new int[n+1];
    int maxLen=1;
    int lastIndex=-1;

    Arrays.fill(dp, 1);
    Arrays.fill(prev,-1);

    for(int i=0;i<n;i++){
      for(int j=0;j<i;j++){
        if(nums[j]<nums[i] && dp[j]+1 >dp[i]){
          dp[i]=dp[j]+1;
          prev[i]=j;
        }
      }
      if(dp[i]>maxLen){
        maxLen=dp[i];
        lastIndex=i;    
      }
    }

    List<Integer> lis=new ArrayList<>();
    int idx=lastIndex;
    while(idx!=-1){
      lis.add(nums[idx]);
      idx=prev[idx];
    }

    Collections.reverse(lis);
    System.out.println(lis);
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println("Longest Increasing Subsequences");

    int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
    System.out.println(longestIncreasingSubsequence(nums));
  }
}
