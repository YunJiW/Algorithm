/**
 * 알고리즘 : DP 알고리즘.
 */
class Solution {
    public int solution(int n, int[] money) {
        int dp[][] = new int[money.length+1][n+1];

        for(int idx = 1; idx < money.length+1;idx++){
            for(int next = 0; next <n+1;next++){
                if(next == 0){
                    dp[idx][next] = 1;
                }
                else{
                    //현재 잔돈보다 작은 경우 -> 이전 값을 가져온다.
                    if(next < money[idx-1]){
                        dp[idx][next] = dp[idx-1][next];
                    }
                    //현재 잔돈 보다 큰경우 점화식 계산 dp[i][j] = dp[i-1][j] + dp[i][j - money[idx]]
                    else{
                        dp[idx][next] = (dp[idx-1][next] + dp[idx][next - money[idx-1]]) % 1000000007;
                    }
                }
            }
        }

        return dp[money.length][n];
    }
}