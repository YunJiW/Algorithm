class Solution {
    public int solution(int n)
    {
        int dp[] = new int[100001];

        dp[0] = 0;
        dp[1] = 1;
        for(int idx = 2; idx <=n;idx++){
            dp[idx] = (dp[idx-2] + dp[idx-1]) %1234567;
        }




        return dp[n]%1234567;


    }

}