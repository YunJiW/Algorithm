class Solution {


    public int solution(int[][] matrix_sizes) {

        int len = matrix_sizes.length;
        int dp[][] = new int[len][len];

        //초기화
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                dp[row][col] = Integer.MAX_VALUE;
            }
        }

        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len - row; col++) {
                int a = col;
                int b = col + row;
                if (a == b) dp[a][b] = 0;
                else {
                    for (int k = a; k < b; k++) {
                        dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k + 1][b] + matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1]);
                    }
                }

            }
        }

        //전체에 대한 곱셈 연산의 최솟값
        return dp[0][len - 1];
    }

}