class Solution {
    public int maxProduct(int[] nums) {
        int maxSofar = nums[0], maxEnding = nums[0], minEnding = nums[0], preMaxEnding;
        for (int i = 1; i < nums.length; i++) {
            preMaxEnding = maxEnding;
            maxEnding = Math.max(nums[i], Math.max(minEnding * nums[i], maxEnding * nums[i]));
            minEnding = Math.min(Math.min(minEnding * nums[i], preMaxEnding * nums[i]), nums[i]);
            maxSofar = Math.max(maxSofar, maxEnding);
        }
        return maxSofar;
    }
}