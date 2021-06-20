class Solution {
    public int reverse(int x) {
        int res = 0, preres = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            if ((res - x % 10) / 10 != preres) return 0;
            preres = res;
            x /= 10;
        }
        return res;  
    }
}