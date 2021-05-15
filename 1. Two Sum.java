class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map <Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) map.put(nums[i], i);
            else {
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        return new int[2];
    }
}

// two-pointers solution

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] newNums = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = new int[]{nums[i], i};
        }

        Arrays.sort(newNums, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, j = nums.length - 1;
        while(i < j) {
            if (newNums[i][0] + newNums[j][0] == target) return new int[]{newNums[i][1], newNums[j][1]};
            else if (newNums[i][0] + newNums[j][0] > target) j--;
            else i++;
        }
        return new int[2];

    }
}