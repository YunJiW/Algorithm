class Solution {
    public static int solution(int[] stones, int k) {
        int n = stones.length;
        int left = 1;
        int right = 200000000;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(stones, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private static boolean isPossible(int[] stones, int k, int num) {
        int count = 0;

        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - num <= 0) {
                count++;
            } else {
                count = 0;
            }

            if (count >= k) {
                return false;
            }
        }

        return true;
    }
}
