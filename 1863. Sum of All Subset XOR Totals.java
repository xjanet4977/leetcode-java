class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length, sum = 0;
        for (int i = 1 << n; i < (1 << n + 1); i++) {
            String s = Integer.toBinaryString(i).substring(1);
            int xor = 0;
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '1') xor ^= nums[j];
            }
            sum += xor;
        }
        return sum;
    }
}