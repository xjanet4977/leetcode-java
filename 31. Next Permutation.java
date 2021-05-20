class Solution {
    int [] nums;
    public void nextPermutation(int[] n) {
        nums = n;
        int idx, i;
        for (i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                idx = findFirstGreaterThanN(i, nums.length - 1, nums[i - 1]);
                swap(idx, i - 1);
                break;

            }
        }
        reverse(i, nums.length - 1);
        return;

    }

    public void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findFirstGreaterThanN(int start, int end, int N) {
        for (int i = end; i >= start; i--){
            if (nums[i] > N) return i;
        }
        return nums.length - 1;
    }

    public void reverse(int i, int j) {
        while (i < j) swap(i++, j--);

    }
}