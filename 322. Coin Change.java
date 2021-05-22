class Solution {
    public int coinChange(int[] coins, int A) {
        int[] dp = new int[A + 1];
        dp[0] = 0;

        for (int i = 1; i <= A; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);

            }
        }
        if (dp[A] == Integer.MAX_VALUE) return -1;
        return dp[A];
    }
}