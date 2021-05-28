class Solution {
    /*
    o: int - how many distinct ways can climb to the top
    i: int - how many steps
    c:
    e: n = 0 -> 0
       n = 1 -> 1
       n = 2 -> 2
       n = 3 -> dp[n] = dp[n - 1] + dp[n - 2];
    */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
}