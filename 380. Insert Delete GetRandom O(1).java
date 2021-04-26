class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> arr;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap();
        arr = new ArrayList();

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        arr.add(val);
        map.put(val, arr.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int loc = map.get(val);
        int lastElement = arr.get(arr.size() - 1);
        arr.set(loc, lastElement);
        map.put(lastElement, loc);

        arr.remove(arr.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */