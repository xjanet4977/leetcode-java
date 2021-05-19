class Solution {
    public int maxSubArray(int[] nums) {
        int maxSofar = nums[0], maxEnding = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            maxSofar = Math.max(maxSofar, maxEnding);
        }
        return maxSofar;

    }
}