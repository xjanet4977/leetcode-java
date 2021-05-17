class Solution {
    public int minSwaps(String s) {
        int one1To0 = 0;
        int one0To1 = 0;
        int zero1To0 = 0;
        int zero0To1 = 0;
        for (int i = 0; i < s.length(); i++) {
            //101010 / 010101
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') one0To1++;
                if (s.charAt(i) == '1') zero1To0++;
            } else {
                if (s.charAt(i) == '0') zero0To1++;
                if (s.charAt(i) == '1') one1To0++;
            }
        }
        int oneNetFlips = one1To0 - one0To1;
        int zeroNetFlips = zero1To0 - zero0To1;

        if (oneNetFlips != 0 && zeroNetFlips != 0) return -1;
        else if (oneNetFlips == 0 && zeroNetFlips != 0) return one0To1;
        else if (oneNetFlips != 0 && zeroNetFlips == 0) return zero0To1;
        else return Math.min(zero0To1, one0To1);


    }
}