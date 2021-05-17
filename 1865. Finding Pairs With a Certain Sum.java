class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> map = new HashMap<>();

    public FindSumPairs(int[] n1, int[] n2) {
        nums1 = n1;
        nums2 = n2;
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) map.put(nums2[i], map.get(nums2[i]) + 1);
            else map.put(nums2[i], 1);
        }
    }

    public void add(int index, int val) {
        map.put(nums2[index], map.get(nums2[index]) - 1);
        if (index >= 0 && index < nums2.length) nums2[index] += val;
        map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int sum = 0;
        for (int j = 0; j < nums1.length; j++) {
            if (map.containsKey(tot - nums1[j])) sum += map.get(tot - nums1[j]);
        }
        return sum;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */