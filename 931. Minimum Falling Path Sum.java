class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, min = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];

        for (int i = 0; i <  n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) dp[i][j] = matrix[i][j];
                else if (j == 0) dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                else if (j == n - 1) dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j];

                if (i == n - 1) min = Math.min(min, dp[i][j]);
            }

        }

        return min;
    }
}