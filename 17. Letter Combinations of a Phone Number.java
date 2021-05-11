// recursion solution
class Solution {
    private static final String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) return result;

        String str = map[digits.charAt(0) - '0'];

        if (digits.length() == 1) {
            for(String l: str.split("")) result.add(l);
            return result;
        }

        List<String> combinations = letterCombinations(digits.substring(1));


        for (int i = 0; i < str.length(); i++){
            for (int j = 0; j < combinations.size(); j++) {
                result.add(str.charAt(i) + combinations.get(j));
            }
        }
        return result;
    }
}

//iterative solution

class Solution {
    private static final String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            result = combine(map[digits.charAt(i) - '0'], result);

        }
        return result;

    }

    public List<String> combine(String digitLetters, List<String> l ) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digitLetters.length(); i++) {
            for (String x : l) {
                result.add(x + digitLetters.charAt(i));
            }
        }
        return result;
    }
}