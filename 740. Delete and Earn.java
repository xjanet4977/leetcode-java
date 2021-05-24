class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] vals = new int[n];

        for (int num: nums) vals[num] += num;

        int dp1 = 0, dp2 = 0;

        for (int i = 0; i < n; i++) {
            int dp = Math.max(dp1, dp2 + vals[i]);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}