class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        if(n >= 2){
            dp[2] = 2;
        }
        
        for(int idx =3;idx <=n;idx++){
            dp[idx] = (dp[idx-2] + dp[idx-1]) % 1000000007;
        }
        
        
        return dp[n] % 1000000007;
    }
}