class Solution {
    public boolean checkZeroOnes(String s) {
        if (s.length() == 1) return s.charAt(0) == '1';
        int windowStart = 0, windowEnd = 0, max1 = 0, max0 = 0;
        for (windowEnd = 1; windowEnd < s.length(); windowEnd++) {
            if (s.charAt(windowEnd) != s.charAt(windowEnd - 1)) {
                windowStart = windowEnd;
            }
            if (s.charAt(windowEnd) == '1') max1 = Math.max(max1, windowEnd - windowStart + 1);
            else max0 = Math.max(max0, windowEnd - windowStart + 1);

        }
        return max1 > max0;
    }
}