class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, middle;

        while (left <= right){
            middle = (left + right) / 2;
            if (nums[middle] == target) return middle;
            if (nums[middle] < target) left = middle + 1;
            else right = middle - 1;
        }

        return -1;

    }
}