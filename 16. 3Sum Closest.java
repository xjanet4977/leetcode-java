class Solution {
    /*
    o: the sum of the three integers that closest to target
    i: nums - array, target - int

    two pointers
    */
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[nums.length - 1] + nums[1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
               int sum = nums[j] + nums[k] + nums[i];
               if (sum == target) return target;

               if (sum > target) k--;
               else j++;

               if (Math.abs(target - sum) < Math.abs(target - closest)) closest = sum;
            }
        }

        return closest;
    }
}