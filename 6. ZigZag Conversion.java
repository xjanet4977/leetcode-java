class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() < numRows) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder("");
        }
        
        int index = 0, step = 1;
        for (int i = 0; i < s.length(); i++) {
            sb[index].append(s.charAt(i));
            if (index == 0) step = 1;
            if (index == numRows - 1) step = -1;
            index += step;
        }
        
        String res = "";
        for (int i = 0; i < sb.length; i++) {
            res += sb[i];
        }
        
        return res;
    }
}