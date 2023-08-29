class Solution {
    int MOD = 20170805;


    public int solution(int m, int n, int[][] cityMap) {
        int rows = m;
        int cols = n;

        int[][][] dp = new int[m][n][2];

        if (cityMap[0][0] == 1) {
            return 0;
        }

        dp[0][0][0] = dp[0][0][1] = 1;

        for (int row = 1; row < rows; row++) {
            if (cityMap[row][0] != 1) dp[row][0][0] = dp[row - 1][0][0];
        }

        for (int col = 1; col < cols; col++) {
            if (cityMap[0][col] != 1) dp[0][col][1] = dp[0][col - 1][1];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                //위에서 내려오는 경우
                if (cityMap[row - 1][col] != 1) {
                    if (cityMap[row - 1][col] == 2) dp[row][col][0] = dp[row - 1][col][0];
                    else dp[row][col][0] = (dp[row - 1][col][0] + dp[row-1][col][1]) % MOD;
                }
                //왼쪽에서 오는 경우
                if (cityMap[row][col-1] != 1){
                    if(cityMap[row][col-1] == 2) dp[row][col][1] = dp[row][col-1][1];
                    else dp[row][col][1] = (dp[row][col-1][0] + dp[row][col-1][1]) %MOD;
                }
            }

        }

        return (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
    }
}