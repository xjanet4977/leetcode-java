class Solution {
    int[] numsArray;
    public int maxSubArray(int[] nums) {
        numsArray = nums;
        return findBestSubarray(0, numsArray.length - 1);
    }

    public int findBestSubarray(int left, int right) {
        if (left > right) return Integer.MIN_VALUE;

        int mid = Math.floorDiv(left + right, 2);
        int curr = 0;
        int bestLeftSum = 0;
        int bestRightSum = 0;

        for (int i = mid - 1; i >= left; i--) {
            curr += numsArray[i];
            bestLeftSum = Math.max(curr, bestLeftSum);
        }

        curr = 0;
        for (int i = mid + 1; i <= right; i++) {
            curr += numsArray[i];
            bestRightSum = Math.max(curr, bestRightSum);
        }

        int bestMidSum = bestRightSum + numsArray[mid] + bestLeftSum;

        int findBestLeftSum = findBestSubarray(left, mid - 1);
        int findBestRightSum = findBestSubarray(mid + 1, right);

        return Math.max(bestMidSum, Math.max(findBestLeftSum, findBestRightSum));
    }

    }
}