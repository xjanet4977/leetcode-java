class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // base case
        if (nums.length < 2) {
            List<Integer> list = new ArrayList();
            list.add(nums[0]);
            result.add(list);
            return result;
        }

        int[] newNums;
        List<List<Integer>> temp;

        for (int i = 0; i < nums.length; i++) {
            newNums = removeElementFromArray(nums, i);
            temp = permute(newNums);
            for (int j = 0; j < temp.size(); j++){
                List<Integer> l = temp.get(j);
                l.add(0, nums[i]);
                result.add(l);
            }

        }
        return result;
    }

    public int[] removeElementFromArray(int[] nums, int idx){
        int[] result = new int[nums.length - 1];

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i != idx) {
                result[j] = nums[i];
                j++;
            }
        }
        return result;
    }
}