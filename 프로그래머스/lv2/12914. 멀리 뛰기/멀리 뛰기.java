class Solution {
    public long solution(int n) {
        
        int dp[] = new int[2001];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int index = 3; index <=n;index++){
            dp[index] = (dp[index-2]%1234567) + (dp[index-1]%1234567);
        }
        return dp[n]%1234567;
    }
}