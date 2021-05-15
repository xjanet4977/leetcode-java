// Hashmap solution
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(target - nums[j])) {
                    List<Integer> triplet = Arrays.asList(nums[i], target - nums[j], nums[j]);
                    Collections.sort(triplet);
                    set.add(triplet);

                } else {
                    map.put(nums[j], j);
                }
            }
        }

        return new ArrayList(set);
    }
}
// two pointer with set solution
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[j] +  nums[k] == target) {
                    set.add(Arrays.asList(nums[j], nums[k], nums[i]));
                    j++;
                    k--;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return new ArrayList(set);
    }
}