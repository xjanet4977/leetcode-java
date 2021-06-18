class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), max = 0, start = 0, end = 0;
        boolean[][] dp = new boolean[n][n];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) dp[i][j] = true;
                else if (j - i == 1) dp[i][j] = s.charAt(j) == s.charAt(i);
                else dp[i][j] = dp[i+1][j-1] && s.charAt(j) == s.charAt(i);
                
                if(dp[i][j] && j - i + 1 > max) {
                    start = i;
                    end = j;
                    max = j - i + 1;
                } 
            }
        }
        
        return s.substring(start, end+1); 
    }
}